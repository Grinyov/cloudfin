package edu.fintime.cloudfin.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * Created by grinyov
 */
@Controller
@RequestMapping("/info")
public class InfoTagController {

    @Autowired
    private WebApplicationContext webAppContext;
    private final static LocalDateTime startDateTime =
            LocalDateTime.now();
    private final static DateTimeFormatter DT_FORMATTER =
            DateTimeFormatter.ofPattern("EEE, d MMM yyyy h:mm a");
    @RequestMapping("/server")
    @ResponseBody
    public String infoTagServer(){
        return new StringJoiner("<br>")
                .add("-------------------------------------")
                .add(" Server: "+
                        webAppContext.getServletContext())
                .add(" Start date: "+
                        startDateTime.format(DT_FORMATTER))
                .add(" Version: " +
                        webAppContext.getBean("webAppVersion"))
                .add("--------------------------------------")
                .toString();
    }
    @RequestMapping("/helloHandler")
    @ResponseBody
    public String helloController(){
        return "hello";
    }
}
