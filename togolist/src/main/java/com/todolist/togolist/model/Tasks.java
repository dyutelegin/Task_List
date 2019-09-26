package com.todolist.togolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nametask")
    private String nametask;

    @Column(name = "date")
    private Date date;

    public Tasks() {
    }

    public Tasks(String nametask, Date date) {
        this.nametask = nametask;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setNametask(String nametask) {
        this.nametask = nametask;
    }

    public String getNametask() {
        return this.nametask;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Tasks [id=" + id + ", nametask=" + nametask + ", date=" + date + "]";
    }
}
