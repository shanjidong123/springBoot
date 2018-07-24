package com.yy.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
//@ResponseBody
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = {"/hello","/hi/{id}"},method = RequestMethod.GET)
    @GetMapping(value = {"/hello","/hi/{id}"})
    public String say (@PathVariable("id") Integer id,@RequestParam(value = "age",required = false,defaultValue = "18") Integer age){
//        return content;
//          return girlProperties.getCupSize();
//        return "index";
        age = 20;
        return "id: " + id + "age: " + age;
    }
}
