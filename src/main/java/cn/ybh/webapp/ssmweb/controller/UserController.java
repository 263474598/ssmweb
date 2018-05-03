package cn.ybh.webapp.ssmweb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ybh.webapp.ssmweb.entity.User;
import cn.ybh.webapp.ssmweb.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private UserService userService;  
  
    @RequestMapping("/profile")  
    public String profile(HttpServletRequest request, Model model) {  
        String idStr = request.getParameter("id");  
        if(null != idStr && !"".equals(idStr.trim())){  
            int userId = Integer.valueOf(idStr);  
            User user = this.userService.getUserById(userId);  
            model.addAttribute("user", user);  
            return "User/profile";  
        } else {  
            return "User/index";  
        }  
    }  
      
    @RequestMapping("/register")  
    public String register(HttpServletRequest request, Model model) {  
        return "User/register";  
    }  
      
    @RequestMapping(value="/register", method=RequestMethod.POST)  
    public String doRegister(HttpServletRequest request, Model model) {  
        String username = request.getParameter("username");  
        String nickname = request.getParameter("nickname");  
        String password = request.getParameter("password");  
        String phone = request.getParameter("phone");  
        User user = new User();  
        user.setUsername(username);  
        user.setPassword(password);  
        user.setPhone(phone);  
        user.setNickname(nickname);  
        int id = userService.addUser(user);  
          
        return String.format("User/profile?id=%d", id);  
    }  
}  