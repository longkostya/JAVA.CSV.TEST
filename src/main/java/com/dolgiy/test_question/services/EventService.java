package com.dolgiy.test_question.services;

import com.dolgiy.test_question.daos.EventDao;
import com.dolgiy.test_question.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {                             //реализация абстрактных методов, описанных в EventDao
    @Autowired
    private EventDao eventDao;

    public Event addEvent(Event event) {
        return eventDao.save(event);
    }

    public List<String> getUserWho() {
        return (List<String>) eventDao.findUserWho();
    }

    public List<String> getTop5Form() {
        return (List<String>) eventDao.findTop5();
    }
}
