package lanpeople.controller;

import lanpeople.dao.SysUserDao;
import lanpeople.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private SysUserDao dao;

    @RequestMapping("doLogin")
    public String doLogin(String username, String password, ModelMap model){
        if (username == null || "".equals(username)){
                model.addAttribute("errormsg","请输入用户名!");
                return "../../index";
        }
        if (password == null || "".equals(password)){
            model.addAttribute("username",username);
            model.addAttribute("errormsg","请输入密码!");
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
        return "main";
    }
}
