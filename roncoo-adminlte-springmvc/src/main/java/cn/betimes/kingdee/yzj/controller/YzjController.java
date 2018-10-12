package cn.betimes.kingdee.yzj.controller;

import cn.betimes.kingdee.yzj.auth.AppAuth2;
import cn.betimes.kingdee.yzj.util.HttpUtil;
import cn.betimes.kingdee.yzj.util.YzjUtil;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.service.UserService;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.base.BaseController;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * zk-mobile
 *
 * @Description: 云之家控制器
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2018/1/12 21:07
 */
@Controller
@RequestMapping(value = "/yzj")
public class YzjController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(YzjController.class);

    @Value("#{configProperties['yzj.appId']}")
    private String appId;
    @Value("#{configProperties['yzj.appSecret']}")
    private String appSecret;

    @Autowired
    private UserBiz biz;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "auth")
    public String auth(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        try {

            String getTokenUrl = "http://www.yunzhijia.com/gateway/oauth2/token/getAccessToken";
            Map<String, String> reqParams = new HashMap<>();
            reqParams.put("appId", appId);
            reqParams.put("secret", appSecret);
            reqParams.put("timestamp", System.currentTimeMillis() + "");
            reqParams.put("scope", "app");
            JSONObject result2 = HttpUtil.httpPost(getTokenUrl, reqParams);

            String ticket = request.getParameter("ticket");

            String authStr = AppAuth2.appAuth2Treaty(appId, appSecret);
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("authorization", authStr);
            response.setHeader("authorization", authStr);
            String responseStr = YzjUtil.post("https://do.yunzhijia.com/openauth2/api/appAuth2", headerMap, null, null);
            System.out.println(responseStr);
            JSONObject authJSON = JSONObject.fromObject(responseStr);
            String token = null;
            if (authJSON.getBoolean("success")) {
                JSONObject data = authJSON.getJSONObject("data");
                token = data.getString("access_token");

                String url2 = "http://do.yunzhijia.com/openauth2/api/getcontext?ticket=" + ticket + "&access_token=" + token;
                JSONObject jsonObject = HttpUtil.httpGet(url2);

                if (jsonObject.has("openid")) {
                    String openId = jsonObject.getString("openid");
                    model.put("openId", openId);
                    RcUser user = biz.findUserByOpenId(openId);
                    if (user == null) {
                        return redirect("/login?openId={0}", openId);
                    } else {
                        String password = Base64Util.decode(user.getPassword());
                        UsernamePasswordToken token2 = new UsernamePasswordToken(user.getUserNo(), password);
                        token2.setRememberMe(true);
                        try {
                            SecurityUtils.getSubject().getSession().setAttribute(Constants.Token.YZJ_OPEN_ID, openId);
                            SecurityUtils.getSubject().login(token2);
                            return redirect("/admin/index");
                        } catch (Exception e) {
                        }
                    }
                } else {
                    return redirect("/login");
                }
            }
        } catch (Exception e) {
            logger.error("yzj auth error:{}",e.getMessage());
        }
        return redirect("/login");

    }

    /**
     * 解绑账号
     * @param request
     */
    @RequestMapping(value = "unBind")
    @ResponseBody
    public String unBind(HttpServletRequest request) {
        JSONObject result = new JSONObject();

        try {
            Session session = SecurityUtils.getSubject().getSession();
            RcUser user = (RcUser) session.getAttribute(Constants.Token.USER_INFO);
            user.setYZJOpenId("");
            userService.update(user);
            result.put("success", true);
            result.put("msg", "操作成功");
            SecurityUtils.getSubject().logout();
            logger.info("unbind user yzj account success: {}", user);
        } catch (Exception e){
            logger.error("unbind yzj openId error: {}", e.getMessage());
            result.put("success", false);
            result.put("msg", "操作失败");
        }
        return result.toString();
    }
}
