package com.example.LearningBoot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
class DataController {
    public static List<String> userNameList = new ArrayList<String>(Arrays.asList("Alice","Bob","Charlie"));
    @PostMapping("/add")
    public String addData(@RequestBody Map<String, String> data) {
        userNameList.add(data.get("name"));
        return "Received: " + data.get("name");
    }
}

@RestController
@RequestMapping("/api")
class DeleteUserController{
    @DeleteMapping("/del")
    List<String> delData(@RequestBody Map<String,String> data){
        DataController.userNameList.remove(data.get("name"));
        return DataController.userNameList;
    }
}

@RestController
@RequestMapping("/api")
class UserController {
    @GetMapping("/users")
    public List<String> getUsers(){
        return DataController.userNameList ;
    }
}

@RestController         // rest api controller
@RequestMapping("/api")  // base URL for this controller   
public class HelloController {

    @GetMapping("/hello")   //get requests at /api/hello
    public String sayHello(){
        return "Hello World, welcome to Spring Boot!!!";
    }
}

@RestController
@RequestMapping("/api")
class GreetingController{
    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name){             // takes value from the url and inject into method
        return "Heyy " + name + " !";
    }
    @GetMapping("/square")
    public int square(@RequestParam int number) {               // takes query type value with "number=value"
        return number * number;
    }
}

