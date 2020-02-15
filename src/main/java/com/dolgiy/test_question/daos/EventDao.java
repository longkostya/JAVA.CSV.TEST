package com.dolgiy.test_question.daos;

import com.dolgiy.test_question.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventDao extends CrudRepository<Event, Integer> {


    Iterable<Event> findBySsoid(String ssoid);
    @Query("select e.ssoid, e.subtype from Event e where e.subtype <> 'send' AND e.subtype <> 'start'")
    List<String> findUserWho();//Пользователи, не дошли до конца
    @Query("select e.formid, count(e.formid) as CountOfUsages from Event e group by e.formid  order by CountOfUsages")
    List<String>findTop5();//самые используемые формы
}
