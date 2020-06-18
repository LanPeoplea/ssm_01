package lanpeople.controller;

import lanpeople.dao.SysUserDao;
import lanpeople.pojo.SysUser;
import lanpeople.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SysUserDao dao;

    @RequestMapping("doLogin")
    public String doLogin(String username, String password,String verifyCode,HttpSession session, ModelMap model){
        if (username == null || "".equals(username)){
                model.addAttribute("errormsg","请输入用户名!");
                return "../../index";
        }
        if (password == null || "".equals(password)){
            model.addAttribute("username",username);
            model.addAttribute("errormsg","请输入密码!");
            return "../../index";
        }
        //验证码校验
        if (verifyCode == null || "".equals(verifyCode)){
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("errormsg","请输入验证码!");
            return "../../index";
        }
        String sessionVerifyCode = (String)session.getAttribute("verifyCode");
        if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("errormsg","验证码错误!");
            return "../../index";
        }
        SysUser sysUser = dao.queryByLoginName(username);
        if (sysUser == null){
            model.addAttribute("username",username);
            model.addAttribute("errormsg","用户名不存在!");
            return "../../index";
        }
        if (!password.equals(sysUser.getPassword())){
            model.addAttribute("username",username);
            model.addAttribute("errormsg","密码错误!");
            return "../../index";
        }


//        return "main";
        return "backstage";
    }
    /**
     * 图片验证码
     */
    @RequestMapping("verify")
    public void graphicVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        String verifyCode = VerifyCode.runVerifyCode(4);
        session.setAttribute("verifyCode", verifyCode);
        try {
            ImageIO.write(VerifyCode.CreateImage(verifyCode), "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
