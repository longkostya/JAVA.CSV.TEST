package com.dolgiy.test_question.services;

import com.dolgiy.test_question.daos.EventDao;
import com.dolgiy.test_question.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {                             //Класс управления, здесь реализовываются методы, унаследованные от EventDao
    @Autowired
    private EventDao eventDao;

    public Event addEvent(Event event) {
        return eventDao.save(event);
    }

    public List<String> getUserWhoDidNotEnded() {
        return (List<String>) eventDao.findUserWhoDidNotEnded();
    }

    public List<String> getTopForm() { return (List<String>) eventDao.findTopForm(); }

    public List<String> getAllSsoid() { return (List <String>) eventDao.findAllSsoid(); }

    public List<String> getFormBySsoid(String a) { return (List <String>) eventDao.findFormBySsoid(a); }

}
