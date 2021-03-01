package it.academy.rest;

import it.academy.model.VisitorCount;
import it.academy.service.VisitorCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorCountRestService {

    @Autowired
    private VisitorCountService visitorCountService;

    @GetMapping("/visitor_count")
    public VisitorCount readCount(int id){
        return null;
    }

    @PutMapping("/visitor_count")
    public VisitorCount updateCount(int id){
        return null;
    }

}
