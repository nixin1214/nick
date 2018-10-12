package cn.betimes.kingdee.eas.controller;

import com.kingdee.eas.cp.eip.sso.ltpa.LtpaToken;
import com.kingdee.eas.cp.eip.sso.ltpa.LtpaTokenManager;
import com.roncoo.adminlte.util.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Description: EAS对接控制器
 * @Author: Andrew(andrew_luo @ foxmail.com)
 * @Date: 2018/3/9 11:08
 */
@Controller
@RequestMapping(value = "eas")
public class EASController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("#{configProperties['eas.ssoPath']}")
    private String ssoPath;

    /**
     * EAS门户单点登录
     *
     * @param username 用户名
     * @return 重定向至EAS单门
     */
    @RequestMapping(value = "ssoLogin")
    public String ssoLogin(@RequestParam(required = true, defaultValue = "user") String username) throws UnsupportedEncodingException {
        URL url = this.getClass().getClassLoader().getResource("LtpaToken.properties");
        LtpaToken token = LtpaTokenManager.generate(username, url.getPath());
        logger.info("eas sso user:{}, token: {}", username, token);
        return redirect(ssoPath, URLEncoder.encode(username, "UTF-8"), URLEncoder.encode(token.toString(), "UTF-8"));
    }
}
