package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.common.ResponseMessage;
import com.example.SpringBootDemo.common.ResponseUtils;
import com.example.SpringBootDemo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import static com.example.SpringBootDemo.constant.ConstantString.PAGE_INDEX;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAllAttributes(getIndexData().asMap());
        return PAGE_INDEX;
    }

    @RequestMapping("/getIndexData")
    @ResponseBody
    public ResponseMessage getIndexData() {
        return ResponseUtils.buildSuccessReponseMessage(indexService.getIndexData());
    }




}
