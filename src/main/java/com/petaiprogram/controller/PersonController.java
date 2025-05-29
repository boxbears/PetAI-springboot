package com.petaiprogram.controller;

import com.petaiprogram.domain.Person;
import com.petaiprogram.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/miniTest")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/getTest")
    public String GetMapperTest01(){
        return "黎明！！！！！！！！";
    }
    @PostMapping("/postTest")
    public String PostMapperTest01(){
        return "Post请求发送成功!";
    }
    @PostMapping("/getPersonList")
    public List<Person> getPersonList(){
        return personService.list();
    }

    @GetMapping("/getColors")
    public ArrayList<String> getColors() {
        Random random = new Random();
        ArrayList<String> arr=new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String num1 = random.nextInt(255) + 1 + "";
            String num2 = random.nextInt(255) + 1 + "";
            String num3 = random.nextInt(255) + 1 + "";
            String num = num1 + "," + num2 + "," + num3;
            arr.add(num);
        }
        return arr;
    }
}
