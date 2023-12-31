package com.fulwin.jd.controller;

import com.fulwin.jd.pojo.Content;
import com.fulwin.jd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws IOException {
        return contentService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Content> search(@PathVariable("keyword") String keyword,
                                @PathVariable("pageNo") int pageNo,
                                @PathVariable("pageSize") int pageSize) throws IOException {

        return contentService.searchPage(keyword,pageNo,pageSize);
    }
}
