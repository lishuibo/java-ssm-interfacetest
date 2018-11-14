package com.litl.www.controller;

import com.litl.www.pojo.User;
import com.litl.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/UserManager")
public class UserManagerController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Boolean login(HttpServletResponse response, @RequestBody User user) {
        int i = userService.login(user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Boolean addUser(HttpServletRequest request, @RequestBody User user) {
        Boolean i = verifyCookies(request);
        int addUser = 0;
        if (i == true) {
            addUser = userService.addUser(user);
        }
        if (addUser > 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user) {
        Boolean i = verifyCookies(request);
        if (i == true) {
            List<User> users = userService.getUserInfo(user);
            return users;
        }
        return null;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(HttpServletRequest request, @RequestBody User user) {
        Boolean i = verifyCookies(request);
        if (i == true) {
            int updateUser = userService.updateUser(user);
            return updateUser;
        }
        return 0;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(HttpServletRequest request, @RequestBody User user) {
        Boolean i = verifyCookies(request);
        if (i == true) {
            int deleteUser = userService.deleteUser(user);
            return deleteUser;
        }
        return 0;
    }

    public Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return false;
        }
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
                return true;
            }
        }
        return false;
    }
}
