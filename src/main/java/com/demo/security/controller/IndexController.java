package com.demo.security.controller;

import com.demo.security.Utils.FakeUtils;
import com.demo.security.domain.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @GetMapping("/news")
    public List<News> news() {
        return FakeUtils.getAllNews();
    }

    @GetMapping("/fuck")
    public String quang(){
        return "fuck that shit";
    }
}
