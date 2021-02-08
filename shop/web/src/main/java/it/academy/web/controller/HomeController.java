package it.academy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class HomeController {

    private static final Logger log=Logger.getLogger(HomeController.class.getName());


//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping(path = "/")
    public ModelAndView home(ModelAndView modelAndView, @RequestParam(value = "param",required = false) String param){
        log.info("Calling home()");
        modelAndView.addObject("userName","Guest");
        modelAndView.addObject("paramValue",param);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
