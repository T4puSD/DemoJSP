package com.example.demojsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticFileServerController {

    @GetMapping("/admin/ng/**")
    public String ngIndex() {
        return "ng-admin/dist/index";
    }
}
