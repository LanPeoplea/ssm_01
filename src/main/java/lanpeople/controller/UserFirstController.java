package lanpeople.controller;

import lanpeople.dao.UserDao;
import lanpeople.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserFirstController {

    @Autowired
    private UserDao dao;

    @RequestMapping("queryall")
    public String queryAll(Model model){
        List<User> list = dao.queryAll();
        model.addAttribute("users",list);
        return "user/user";
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String,String> delete(String id){
        int rst = dao.delete(id);
        Map<String,String> rtnMap = new HashMap<>();
        if (rst>0) {
            rtnMap.put("status","200");
            rtnMap.put("msg","删除成功");
        }else{
            rtnMap.put("status","300");
            rtnMap.put("msg","删除失败");
        }
        return rtnMap;
    }

    @RequestMapping("toEdit")
    public String toEdit(String id, ModelMap modelMap){
        User user =dao.queryById(id);
        modelMap.addAttribute("user",user);
        return "user/toEdit";
    }

    @RequestMapping("edit")
    public String edit(User user){
        int rst = dao.update(user);
        return "redirect:queryall";
    }
    @RequestMapping("toAdd")
    public String toAdd(User user){
        return "user/toAdd";
    }
    @RequestMapping("add")
    public String add(User user){
        int rst = dao.add(user);
        return "redirect:queryall";
    }

}
