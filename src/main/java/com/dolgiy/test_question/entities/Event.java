package com.dolgiy.test_question.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity //указывает, что это не просто класс, а сущность, которая будет храниться в БД
@Table(schema = "csv",name ="Events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int Id; //ИД записи в таблице
    private String Ssoid; //Уникальный ИД пользователя
    private Integer Ts;//время
    private String Grp;//группа события
    private String Type;//тип события
    private String Subtype;//подтип события
    private String Url;//Адрес, с которого пришло событие
    private String Orgid;//Организация, предоставляющая услугу
    private String Formid;//Идентификатор формы
    private String Code;//??
    private String Ltpa;//ключ сессии (пустой)
    private String Sudirresponce;//ответ от сервиса авторизации (пустой)
    private Timestamp Ymdh;//Дата в формате YYYY-MM-DD-HH (TimeStamp - наиболее подходящий тип)

    public Event() {
    }

    public String toString(){
        return Ssoid+" /"+Ts+" /"+Grp+" /"+Type+" /"+Subtype+" /"+Url+" /"+Orgid+" /"+Formid+" /"+Code+" /"+Ltpa+" /"+Sudirresponce+" /"+Ymdh+"\n";
    }
    public void setId(int id) {
        Id = id;
    }

    public void setSsoid(String ssoid) {
        Ssoid = ssoid;
    }

    public void setTs(Integer ts) {
        Ts = ts;
    }

    public void setGrp(String grp) {
        Grp = grp;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setSubtype(String subtype) {
        Subtype = subtype;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setOrgid(String orgid) {
        Orgid = orgid;
    }

    public void setFormid(String formid) {
        Formid = formid;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setLtpa(String ltpa) {
        Ltpa = ltpa;
    }

    public void setSudirresponce(String sudirresponce) {
        Sudirresponce = sudirresponce;
    }

    public void setYmdh(Timestamp ymdh) {
        Ymdh = ymdh;
    }

    public int getId() {
        return Id;
    }

    public String getSsoid() {
        return Ssoid;
    }

    public Integer getTs() {
        return Ts;
    }

    public String getGrp() {
        return Grp;
    }

    public String getType() {
        return Type;
    }

    public String getSubtype() {
        return Subtype;
    }

    public String getUrl() {
        return Url;
    }

    public String getOrgid() {
        return Orgid;
    }

    public String getFormid() {
        return Formid;
    }

    public String getCode() {
        return Code;
    }

    public String getLtpa() {
        return Ltpa;
    }

    public String getSudirresponce() {
        return Sudirresponce;
    }

    public Timestamp getYmdh() {
        return Ymdh;
    }
}
