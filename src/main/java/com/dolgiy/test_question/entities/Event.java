package com.dolgiy.test_question.entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity //указывает, что это не просто класс, а сущность, которая будет храниться в БД
@Table(schema = "csv",name ="Events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id; //ИД записи в таблице
    private String ssoid; //Уникальный ИД пользователя
    private Integer ts;//время
    private String grp;//группа события
    private String type;//тип события
    private String subtype;//подтип события
    private String url;//Адрес, с которого пришло событие
    private String orgid;//Организация, предоставляющая услугу
    private String formid;//Идентификатор формы
    private String code;//??
    private String ltpa;//ключ сессии (пустой)
    private String sudirresponce;//ответ от сервиса авторизации (пустой)
    private Timestamp ymdh;//Дата в формате YYYY-MM-DD-HH (TimeStamp - наиболее подходящий тип)

    public void setId(int id) {
        id = id;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public void setSudirresponce(String sudirresponce) {
        this.sudirresponce = sudirresponce;
    }

    public void setYmdh(Timestamp ymdh) {
        this.ymdh = ymdh;
    }

    public int getId() {
        return id;
    }

    public String getSsoid() {
        return ssoid;
    }

    public Integer getTs() {
        return ts;
    }

    public String getGrp() {
        return grp;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getUrl() {
        return url;
    }

    public String getOrgid() {
        return orgid;
    }

    public String getFormid() {
        return formid;
    }

    public String getCode() {
        return code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public String getSudirresponce() {
        return sudirresponce;
    }

    public Timestamp getYmdh() {
        return ymdh;
    }

    public Event() {
    }

    public String toString(){
        return ssoid+" /"+ts+" /"+grp+" /"+type+" /"+subtype+" /"+url+" /"+orgid+" /"+formid+" /"+code+" /"+ltpa+" /"+sudirresponce+" /"+ymdh+"\n";
    }

}
