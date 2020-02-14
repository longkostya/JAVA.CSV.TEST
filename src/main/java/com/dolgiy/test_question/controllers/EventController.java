package com.dolgiy.test_question.controllers;

import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam String ssoid, @RequestParam String subtype, Model model) {
        model.addAttribute("ssoid", ssoid);
        model.addAttribute("subtype", subtype);
        return "greeting";
    }
}