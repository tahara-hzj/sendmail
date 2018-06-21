package com.lanpin.sendmail.controller;

import com.lanpin.sendmail.common.Config;
import com.lanpin.sendmail.util.SendMailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author  Jello
 * @create  2018/6/21 16:13
 * @desc    实现邮件的发送
 **/
@Controller
public class SendEmailController {

    @GetMapping("/sendMail")
    @ResponseBody
    public Map<String, Object> sendMail() {
        String randNum = "";
        Map<String, Object> map = null;
        try {
            StringBuffer sb = new StringBuffer();
            randNum = SendMailUtil.getRandNum();
            sb.append("<!DOCTYPE>" + "<div bgcolor='#f1fcfa'" +
                    "style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                    + "<div style='width:950px;font-family:arial;'>欢迎参加【倾城出行】活动，您的注册码为：<br/><h2 style='color:green'>" + randNum + "</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。" +
                    "<br/>广东蓝聘科技网络有限公司</div>"
                    + "</div>");

            map = SendMailUtil.sendMail(Config.USER, Config.PASSWORD, Config.HOST, Config.FROM, Config.TO, Config.SUBJECT, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
