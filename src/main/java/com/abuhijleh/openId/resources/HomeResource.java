package com.abuhijleh.openId.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/admin/authorize")
    public String home(){
        return ("true");
    }

    @GetMapping("/user/authorize")
    public String user(){
        return ("true");
    }

}
