package edu.sch.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    static class Person{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @ResponseBody
    @GetMapping("spring-person")
    public Person springPerson(@RequestParam("name") String name,
                               @RequestParam("age") int age, Model model) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }

    // Get -> spring-api
    @ResponseBody
    @GetMapping("/spring-api")
    public String springApi(@RequestParam("name") String name,
                            @RequestParam("age") String age, Model model) {
        //model.addAttribute("name", name);

        return "spring-api" + "<br><br>name: " + name + "<br>age: " + age;
    }

    @GetMapping("/qwer")
    public String hello(Model model) {
        model.addAttribute("data", "qwer");
        model.addAttribute("unknown", "asdf");

        return "hello";  //템플릿 엔진의 hello라는 View 이름 리턴 (file name)
    }

    @GetMapping("/spring-mvc")
    public String springMvc(@RequestParam("name") String name,
                            @RequestParam("age") int age,  Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "spring-mvc";
    }
}


// { ".." : ".." }   -> *.json (java_script object notation) - RESTful API