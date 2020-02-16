package com.dolgiy.test_question.daos;

import com.dolgiy.test_question.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;

public interface EventDao extends CrudRepository<Event, Integer> {

    @Query("select e.ssoid, e.subtype,  e.ts  from Event e where e.subtype <> 'send' AND e.subtype <> 'start' order by e.ssoid, e.ts")
    List<String> findUserWhoDidNotEnded();                                  //Пользователи, не дошли до конца

    @Query("select e.formid, count(e.formid) as CountOfUsages from Event e group by e.formid  order by CountOfUsages desc")
    List<String>findTopForm();                                              //Отсортированный список самых используемых форм

    @Query("select distinct e.ssoid from Event e")
    List<String>findAllSsoid();                                             //Список всех уникальых ssoid

    @Query("select  e.formid from Event e where e.ssoid=?1")
    List<String>findFormBySsoid(String a);                                  //Список всех используемых форм по заданному ssoid
}
