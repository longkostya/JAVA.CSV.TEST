package com.dolgiy.test_question.daos;

import com.dolgiy.test_question.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventDao extends CrudRepository<Event, Integer> {

 //   @Query("SELECT DISTINCT  ssoid FROM events")
    //List<Event> findSsoid();
    //List<Event> findBySsoid(String ssoid);

   // @Override
    Iterable<Event> findBySsoid(String ssoid);
    @Query("select e.ssoid, e.subtype from Event e where e.subtype <> 'send' AND e.subtype <> 'start'")
    List<String> findUserWho();
}
