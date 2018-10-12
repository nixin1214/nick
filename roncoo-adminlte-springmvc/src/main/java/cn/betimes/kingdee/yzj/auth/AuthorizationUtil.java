package cn.betimes.kingdee.yzj.auth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationUtil
{
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationUtil.class);

    public static Random RAND = new Random();

    private static final Base64 BASE64 = new Base64();
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String DEFAULT_SIGNATURE_METHOD = "HMAC-SHA1";
    private static String characterEncoding = "UTF-8";

    public static String generateAuthorizationHeader(String consumerKey, String consumerSecret, String signatureMethod, long timestamp, String nonce, float version, String oauthToken, String oauthTokenSecret, String verifier, String url, Map<String, Object> parameters, String requestType)
            throws URISyntaxException, IOException, GeneralSecurityException
    {
        if (StringUtils.isEmpty(consumerKey)) {
            throw new IllegalArgumentException("consumerKey is null or empty!");
        }
        if (StringUtils.isEmpty(consumerSecret)) {
            throw new IllegalArgumentException("consumerSecret is null or empty!");
        }
        if (null == nonce) {
            throw new IllegalArgumentException("nonce is null!");
        }
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url is null or empty!");
        }
        if (StringUtils.isEmpty(requestType)) {
            throw new IllegalArgumentException("requestType is null or empty!");
        }

        if (StringUtils.isEmpty(signatureMethod)) {
            signatureMethod = "HMAC-SHA1";
        }

        Map oauthHeaderParams = new LinkedHashMap();
        oauthHeaderParams.put("oauth_consumer_key", consumerKey);
        oauthHeaderParams.put("oauth_signature_method", signatureMethod);
        oauthHeaderParams.put("oauth_timestamp", String.valueOf(timestamp));
        oauthHeaderParams.put("oauth_nonce", nonce);
        oauthHeaderParams.put("oauth_version", String.valueOf(version));
        if (StringUtils.isNotEmpty(oauthToken)) {
            if (StringUtils.isEmpty(oauthTokenSecret)) {
                throw new IllegalArgumentException("oauthTokenSecret is null or empty!");
            }
            oauthHeaderParams.put("oauth_token", oauthToken);
        }

        if (StringUtils.isNotEmpty(verifier)) {
            oauthHeaderParams.put("oauth_verifier", verifier);
        }

        Map signatureBaseParams = new HashMap(oauthHeaderParams);
        if ((null != parameters) && (!(parameters.isEmpty()))) {
            signatureBaseParams.putAll(parameters);
        }

        parseGetParameters(url, signatureBaseParams);

        String oauthBaseString = getBaseString(requestType, url, signatureBaseParams);
        logger.info("Structure OAuth Authorization: ");
        logger.info("OAuth base string: {}", oauthBaseString);

        String signature = base64Encode(computeSignature(consumerSecret, oauthTokenSecret, oauthBaseString));
        logger.info("OAuth signature: {}", signature);

        oauthHeaderParams.put("oauth_signature", signature);
        String authorization = "OAuth " + encodeParameters(oauthHeaderParams, ",", true);
        logger.info("Authorization: {}", authorization);
        return authorization;
    }

    private static void parseGetParameters(String url, Map<String, Object> signatureBaseParams) {
        int queryStart = url.indexOf("?");
        if (-1 != queryStart) {
            String[] queryStrs = url.substring(queryStart + 1).split("&");
            try {
                for (String query : queryStrs) {
                    String[] split = query.split("=");
                    if (split.length == 2) {
                        signatureBaseParams.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    }
                    else
                        signatureBaseParams.put(URLDecoder.decode(split[0], "UTF-8"), "");
                }
            }
            catch (UnsupportedEncodingException ignore)
            {
            }
        }
    }

    private static String getBaseString(String requestType, String url, Map<String, Object> parameters)
            throws URISyntaxException, IOException
    {
        return percentEncode(requestType.toUpperCase()) + '&' + percentEncode(normalizeUrl(url)) + '&' + percentEncode(normalizeParameters(parameters));
    }

    private static String normalizeUrl(String url) throws URISyntaxException
    {
        URI uri = new URI(url);
        String scheme = uri.getScheme().toLowerCase();
        String authority = uri.getAuthority().toLowerCase();
        boolean dropPort = ((scheme.equals("http")) && (uri.getPort() == 80)) || ((scheme.equals("https")) && (uri.getPort() == 443));

        if (dropPort) {
            int index = authority.lastIndexOf(":");
            if (index >= 0) {
                authority = authority.substring(0, index);
            }
        }
        String path = uri.getRawPath();
        if ((path == null) || (path.length() <= 0)) {
            path = "/";
        }

        return scheme + "://" + authority + path;
    }

    private static List<Entry<String, Object>> getParameters(Collection<ComparableParameter> parameters) {
        if (parameters == null) {
            return null;
        }
        List list = new ArrayList(parameters.size());
        for (ComparableParameter parameter : parameters) {
            list.add(parameter.value);
        }
        return list;
    }

    private static String normalizeParameters(Map<String, Object> parameters) throws IOException {
        if ((null == parameters) || (parameters.isEmpty())) {
            return "";
        }
        List p = new ArrayList(parameters.size());

        for (Entry parameter : parameters.entrySet()) {
            if (!("oauth_signature".equals(parameter.getKey()))) {
                p.add(new ComparableParameter(parameter));
            }
        }

        Collections.sort(p);
        return formEncode(getParameters(p));
    }

    public static String percentEncode(String s) {
        if (StringUtils.isEmpty(s))
            return "";
        try
        {
            return URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException wow) {
            throw new RuntimeException(wow.getMessage(), wow);
        }
    }

    public static String decodeCharacters(byte[] from)
    {
        if (StringUtils.isNotEmpty(characterEncoding)) {
            try {
                return new String(from, characterEncoding);
            } catch (UnsupportedEncodingException e) {
                System.err.println(e + "");
            }
        }
        return new String(from);
    }

    public static String formEncode(Iterable<? extends Entry<String, Object>> parameters) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        formEncode(parameters, b);
        return decodeCharacters(b.toByteArray());
    }

    public static void formEncode(Iterable<? extends Entry<String, Object>> parameters, OutputStream into)
            throws IOException
    {
        boolean first;
        if (parameters != null) {
            first = true;
            for (Entry parameter : parameters) {
                if (first)
                    first = false;
                else {
                    into.write(38);
                }
                into.write(encodeCharacters(percentEncode(toString(parameter.getKey()))));
                into.write(61);
                into.write(encodeCharacters(percentEncode(toString(parameter.getValue()))));
            }
        }
    }

    public static byte[] encodeCharacters(String from) {
        if (characterEncoding != null) {
            try {
                return from.getBytes(characterEncoding);
            } catch (UnsupportedEncodingException e) {
                System.err.println(e + "");
            }
        }
        return from.getBytes();
    }

    private static final String toString(Object from) {
        return ((from == null) ? null : from.toString());
    }

    private static byte[] computeSignature(String consumerSecret, String tokenSecret, String baseString) throws GeneralSecurityException, UnsupportedEncodingException
    {
        String keyString = percentEncode(consumerSecret) + '&' + percentEncode(tokenSecret);

        byte[] keyBytes = keyString.getBytes("UTF-8");
        SecretKey key = new SecretKeySpec(keyBytes, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(key);
        byte[] text = baseString.getBytes("UTF-8");
        return mac.doFinal(text);
    }

    private static String base64Encode(byte[] b) {
        byte[] b2 = BASE64.encode(b);
        try {
            return new String(b2, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.err.println(e + "");
        }
        return new String(b2);
    }

    private static String encodeParameters(Map<String, String> signatureBaseParams, String splitter, boolean quot) {
        StringBuffer buf = new StringBuffer();

        for (String key : signatureBaseParams.keySet()) {
            if (buf.length() != 0) {
                if (quot) {
                    buf.append("\"");
                }
                buf.append(splitter);
            }
            buf.append(percentEncode(key)).append("=");
            if (quot) {
                buf.append("\"");
            }
            buf.append(percentEncode((String)signatureBaseParams.get(key)));
        }

        if ((buf.length() != 0) &&
                (quot)) {
            buf.append("\"");
        }

        return buf.toString();
    }

    public static void main(String[] args)
            throws URISyntaxException, IOException, GeneralSecurityException
    {
        String oauth_consumer_key = "10103";
        String oauth_signature_method = "HMAC-SHA1";
        long oauth_timestamp = System.currentTimeMillis() / 1000L;
        String oauth_nonce = String.valueOf(oauth_timestamp + RAND.nextInt());
        float oauth_version = 1.0F;
        String oauth_token = null;
        String oauth_verifier = null;

        String oauth_consumer_secret = "kingdee20150810";
        String oauth_token_secret = null;
        String url = "http://localhost:8000/openapi/v1/oauth/appToken.json";
        Map parameters = null;
        String requestType = "post";

        logger.info(generateAuthorizationHeader(oauth_consumer_key, oauth_consumer_secret, oauth_signature_method, oauth_timestamp, oauth_nonce, oauth_version, oauth_token, oauth_token_secret, oauth_verifier, url, parameters, requestType));

        oauth_consumer_key = "2AudaAEghEJGEHkw";
        oauth_signature_method = "HMAC-SHA1";
        oauth_timestamp = System.currentTimeMillis() / 1000L;
        oauth_nonce = String.valueOf(oauth_timestamp + RAND.nextInt());
        oauth_version = 1.0F;
        oauth_token = "3f3f94d26637acc3f265c016ca471183";
        oauth_verifier = "3f3f94d26637acc3f265c016ca471183";

        oauth_consumer_secret = "0QNOWUHsWcI9i8UyqBFKUarayqBDUsVnxJrumYHEUl";
        oauth_token_secret = "9a392124d84d6bddd44f86c88bbeca4";
        url = "http://localhost:8000/openapi/v1/ticket/acquire.json";
        parameters = new HashMap();
        parameters.put("openToken", "5fb27cf1b1929c27dade39bf9fcfc6a");
        parameters.put("appid", "10103");
        parameters.put("mid", "10109");
        requestType = "post";

        logger.info(generateAuthorizationHeader(oauth_consumer_key, oauth_consumer_secret, oauth_signature_method, oauth_timestamp, oauth_nonce, oauth_version, oauth_token, oauth_token_secret, oauth_verifier, url, parameters, requestType));
    }

    private static class ComparableParameter
            implements Comparable<ComparableParameter>
    {
        final Entry<String, Object> value;
        private final String key;

        ComparableParameter(Entry<String, Object> value)
        {
            this.value = value;
            String n = toString(value.getKey());
            String v = toString(value.getValue());
            this.key = AuthorizationUtil.percentEncode(n) + ' ' + AuthorizationUtil.percentEncode(v);
        }

        private static String toString(Object from) {
            return ((from == null) ? null : from.toString());
        }

        public int compareTo(ComparableParameter that) {
            return this.key.compareTo(that.key);
        }

        public String toString() {
            return this.key;
        }
    }
}