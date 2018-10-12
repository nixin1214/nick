package cn.betimes.kingdee.yzj.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

/**
 * zk-mobile
 *
 * @Description: 云之家AUTH2认证
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2018/1/12 21:04
 */
public class AppAuth2 {
    private static final String ENC = "UTF-8";

    /**
     * appAuth2协议生成算法
     * @return String OpenAuth2 version="1.1", appid="XXX", timestamp=1436929524676, nonce="XXX", sign="XXX"
     * @throws UnsupportedEncodingException
     */
    public static String appAuth2Treaty(String appid, String appSecret) throws UnsupportedEncodingException {
        String authorization = "OpenAuth2 version=\"%s\", appid=\"%s\", timestamp=%d, nonce=\"%s\", sign=\"%s\"";
        String version = "1.1";
        appid = URLEncoder.encode(appid, ENC);
        long timestamp = System.currentTimeMillis();
        String nonce = URLEncoder.encode(UUID.randomUUID().toString(), ENC);
        String sign = shaHex(version, appid, timestamp + "", nonce, appSecret);
        sign = URLEncoder.encode(sign, ENC);
        authorization = String.format(authorization, version, appid, timestamp, nonce, sign);
        return authorization;
    }

    /**
     * openapi协议
     * @param appid
     * @param token
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String serverAuth2Treaty(String appid, String secret, String token) throws UnsupportedEncodingException {
        String authorization = "OAuth oauth_consumer_key=\"%s\",oauth_signature_method=\"%s\",oauth_timestamp=%d,oauth_nonce=\"%s\",oauth_version=\"%s\",oauth_token=\"%s\",oauth_verifier=\"%s\",oauth_signature=\"%s\"";
        String oauth_signature_method = "HMAC-SHA1";
        String oauth_consumer_secret = secret;
        long oauth_timestamp = System.currentTimeMillis();
        String oauth_nonce = URLEncoder.encode(UUID.randomUUID().toString(), ENC);
        float oauth_version = 1.0f;
        String oauth_token = token;
        String oauth_verifier = "kingdee_zkry";
        String oauth_signature = shaHex(oauth_signature_method, oauth_timestamp+"", oauth_nonce, oauth_version + "", oauth_token, oauth_verifier);
        oauth_signature = URLEncoder.encode(oauth_signature, ENC);

        authorization = String.format(authorization, appid, oauth_signature_method, oauth_timestamp, oauth_nonce, oauth_version, oauth_token, oauth_verifier, oauth_signature);
        System.out.println(authorization);
        return authorization;
    }

    /**
     * shaHex算法
     *
     * @param data
     * @return
     */
    public static String shaHex(String... data) {
        Arrays.sort(data);
        String join = StringUtils.join(data);
        String sign = DigestUtils.shaHex(join);
        return sign;
    }


}
