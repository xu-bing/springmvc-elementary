package com.controller;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserControllerRedirect{
    private List<User> dbList;

    private List<User> userList;

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "userlist";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "adduser";
    }


    // 1. 不带参数重定向
    /*@RequestMapping("/addUser")
    public String addUser(HttpServletRequest request, User user){
        HttpSession session = request.getSession();

        if (session.getAttribute("dbList") == null){
            dbList = new ArrayList<User>();
            dbList.add(user);

            session.setAttribute("dbList", dbList);
        } else {
            dbList = (List<User>) session.getAttribute("dbList");
            dbList.add(user);
        }


        return "redirect:/queryUsers";
    }*/


    // 2. 带参数重定向
    // 2.1 接结URL
    /*public String addUser(HttpServletRequest request, User user){
        HttpSession session = request.getSession();

        if (session.getAttribute("dbList") == null){
            dbList = new ArrayList<User>();
            dbList.add(user);

            session.setAttribute("dbList", dbList);
        } else {
            dbList = (List<User>) session.getAttribute("dbList");
            dbList.add(user);
        }


        return "redirect:/queryUsers?username="+user.getUsername();
        //=> url地址传参，controller中收到时会有中文乱码。
    }*/

    // 2.2 使用RedirectAttributes
    // (a) 使用addAttribute方法传递参数会跟在URL后面
    // (b) 使用addFlashAttribute方法传递参数不会跟随在URL后面，会把该参数值暂时保存于session，当重定向url获取该参数后就会从session中移除。
    @RequestMapping("/addUsr")
    public String addUser(HttpServletRequest request, User user, RedirectAttributes attrs){
        HttpSession session = request.getSession();

        if (session.getAttribute("dbList") == null){
            dbList = new ArrayList<User>();
            dbList.add(user);

            session.setAttribute("dbList", dbList);
        } else {
            dbList = (List<User>) session.getAttribute("dbList");
            dbList.add(user);
        }

        attrs.addAttribute("username", user.getUsername());  // 参数会显示在url地址栏中
        attrs.addFlashAttribute("agee",user.getAge());       // 参数不会显示在url地址栏中

        session.setAttribute("sessionUsername", "直接存在session中的值");

        // return "redirect:/toIndex";
        // => 重定向到index.jsp时会显示agee，再次刷新index.jsp时就不会再显示agee了，而sessionUserName可以取到
        // 说明：参数值暂时保存于session中，在跳转到目标页面获得该参数值后，session就将其删除。

        return "redirect:/queryUsers";
        // => 再访问index.jsp，可以取出sessionUserName, 而agee显示为空。
    }

    /**
     *
     * @param request
     * @param model
     * @param username 接收redirectAtrributes.addAttribute()中的值
     * @param age  接收redirectAttributes.addFlashAtribute()中的值， 需要结合使用ModelAttribute
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("queryUsers")
    public String queryUsers(HttpServletRequest request, Model model, String username,
                             @ModelAttribute("agee") Integer age ) throws UnsupportedEncodingException {

        // -----------------------------------------------------
        // 测试传过来的数据
        username = new String(username.getBytes("iso-8859-1"), "UTF-8");   // 解决url传参乱码问题
        System.out.println("username::::" + username);

        // 获得ddFlashAttribute()中存的数据
        // 不能通过session.getAttribute（）获得
        HttpSession session = request.getSession();
        System.out.println("session_age:::" + session.getAttribute("age"));   // 取不到结果，为null

        // 可以通过ModelAttribute取得
        System.out.println("age:::" + age);

        // -----------------------------------------------------
        HttpSession session1 = request.getSession();

        userList = (List<User>) session1.getAttribute("dbList");

        model.addAttribute("userList", userList);

        return "userlist";
    }   // queryUsers

}
