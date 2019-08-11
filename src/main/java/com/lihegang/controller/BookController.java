package com.lihegang.controller;

import com.lihegang.bean.RedAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dong-er on 2019-08-04.
 */
@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    RedAware redAware;

    @RequestMapping("/testValue")
    public String testValue(@RequestParam("key") String key){
        System.out.println("controller返回的value = " + redAware.getValueFromResolver(key));
        return redAware.getValueFromResolver(key);
    }

}
