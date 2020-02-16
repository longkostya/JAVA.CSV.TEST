package com.dolgiy.test_question.controllers;
import com.dolgiy.test_question.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class EventController {                                                      //здесь обрабатываются данные из Service
                                                                                    //и передаются в ThymeLeaf
    @Autowired
    private EventService eventService;

    @GetMapping("/reportB")
    public String reportB(@RequestParam (required=false) String a, Model model) {
        List<String> UsersWhoDidNotEnded = eventService.getUserWhoDidNotEnded();
        model.addAttribute("UsersWhoDidNotEnded",UsersWhoDidNotEnded);          //передаю в таймлиф массив строк,
        return "reportB";                                                          //полученных в результате запроса
    }

    @GetMapping("/reportC")
    public String reportC(@RequestParam (required=false) String a, Model model) {
        List<String> topForm = eventService.getTopForm();                         //получаю топ ВСЕХ форм
        List <String> top5Form = new ArrayList<String>();                         //сюда кладу первые 5 (костыль)))
        for(int i=0;i<5;i++)
        {
            top5Form.add(topForm.get(i));
        }
        model.addAttribute("top5Form",top5Form);
        return "reportC";
    }

    @GetMapping("/reportA")
    public String reportA(@RequestParam (required=false) String a, Model model) {
        List<String> ssoid = eventService.getAllSsoid();                        //получаю список всех ssoid
        for(int i=0;i<ssoid.size();i++)
        {
            List<String> forms= new ArrayList<String>();                        //сюда кладу
            String rezult=ssoid.get(i)+": ";                                    //сюда склеиваю ssoid+ список используемых форм
            forms = eventService.getFormBySsoid(ssoid.get(i));                  //для каждого ssoid получаю список используемых форм
            for(int j=0;j<forms.size();j++)
            {
                rezult += forms.get(j)+"| ";                                    //сюда склеиваю ssoid+ список используемых форм
            }
            ssoid.set(i,rezult);
        }
        model.addAttribute("SsoidAndForms",ssoid);
        return "reportA";
    }
}
