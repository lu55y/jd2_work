package it.academy.web.controller;


import it.academy.service.PromoService;
import it.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class HomeController {

    private static final Logger log=Logger.getLogger(HomeController.class.getName());

    @Autowired
    SearchService searchService;

    @Autowired
    PromoService promoService;

//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping(path = "/")
    public String home(@RequestParam(value = "searchParam",required = false) String param,
                             Model model){
        if (param!=null&& !"".equals(param.trim())){
            model.addAttribute("searchResult", searchService.searchProducts(param));
            return "search-result";
        }

        log.info("Calling home(): searchParam: "+ param);
        model.addAttribute("promoList", promoService.findAllPromo());
        return "index";
    }

}
