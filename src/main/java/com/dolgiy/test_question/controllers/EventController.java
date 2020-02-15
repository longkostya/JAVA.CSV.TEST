package com.dolgiy.test_question.controllers;
import com.dolgiy.test_question.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/reportB")
    public String reportB(@RequestParam (required=false) String a, Model model) {
        //model.addAttribute("name", name);
        List<String> UsersWho = eventService.getUserWho();
        model.addAttribute("UsersWho",UsersWho);                                //передаю в таймлиф массив строк,
        return "reportB";                                                          //полученных в результате запроса
    }

    @GetMapping("/reportC")
    public String reportC(@RequestParam (required=false) String a, Model model) {
        //model.addAttribute("name", name);
        List<String> top5Form = eventService.getTop5Form();
        model.addAttribute("top5Form",top5Form);
        return "reportC";
    }
}
