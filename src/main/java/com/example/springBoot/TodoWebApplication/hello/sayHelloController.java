package com.example.springBoot.TodoWebApplication.hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //@RestController: This annotation is a specialization of @Controller and is used to create RESTful web services. It combines the functionality of @Controller and @ResponseBody, meaning that the methods within the class will return data directly as responses rather than views (like HTML pages).
public class sayHelloController {
    @RequestMapping("hello-java")
    @ResponseBody
    public String hello(){
        return "Hello, World! What are you learning today";
    }


    @RequestMapping("hello-html")
    @ResponseBody
    public String helloHtml(){
        // StringBuffer is a class in Java, which is used to create a modifible string
        StringBuffer sb = new StringBuffer();

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first HTML page</title>");
        sb.append("<body>");
        sb.append("<h1 style ='color: red'>Hello, Are you ready for change</h1>");
        sb.append("</body>");
        sb.append("</head>");
        sb.append("</html>");
        return sb.toString();
    }


    @RequestMapping("hello-html-jsp")
    public String helloHtmlJsp(){
        return "sayHello";
    }


    @RequestMapping("goodbye-html-jsp")
    public String goodByeHtmlJsp(){
        return "sayGoodBye";
    }
} 
