package com.leafware.lwtemplate.controller;

import com.leafware.lwtemplate.security.AuthoritiesConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DefaultController {

    private static final String infoMsg = "This is a base for leafware projects, please follow the steps described" +
                                      " in the repository readme to customize the project";

    @GetMapping(value = "/info")
    public String info() {
        return infoMsg;
    }

    @GetMapping("/api/hello-world")
    public String helloWorld() { return "Hello world"; }

    @GetMapping("/api/admin/hello-admin")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public String helloAdmin() { return "Hello admin"; }

    @GetMapping("/api/user/hello-user")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.USER + "\")")
    public String helloUser() { return "Hello user"; }
}