package com.kevin.manage.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全局控制器
 * @author zhangguoji
 * @date 2017/8/29 18:17
 */
@Controller
@RequestMapping("/global")
public class GlobalController {
    /**
     * 404页面
     * @return
     */
    @RequestMapping("/error")
    public String errorPage() {
        return "/404.html";
    }

    /**
     * session超时页面
     * @param model
     * @return
     */
    @RequestMapping("/sessionError")
    public String errorPageInfo(Model model) {
        model.addAttribute("tips", "session超时");
        return "/login.html";
    }
}
