package com.wenyao.springsession.controllor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloControllor {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("wenyao", "alibaba");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("wenyao") + ":" + port;
    }
}
