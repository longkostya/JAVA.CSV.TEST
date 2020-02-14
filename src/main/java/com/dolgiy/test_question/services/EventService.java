package com.dolgiy.test_question.services;

import com.dolgiy.test_question.daos.EventDao;
import com.dolgiy.test_question.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventDao eventDao;
    public Event addEvent(Event event){
        return eventDao.save(event);
    }


    public List<Event> getEventInfoBySsoid(String ssoid) {
        return (List<Event>) eventDao.findBySsoid(ssoid);
    }
    public List<String> getUserWho() {
        return (List<String>) eventDao.findUserWho();
    }
}
