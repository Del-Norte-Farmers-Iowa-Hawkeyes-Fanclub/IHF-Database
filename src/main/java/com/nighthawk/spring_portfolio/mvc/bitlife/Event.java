package com.nighthawk.spring_portfolio.mvc.bitlife;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private Long nextEventOption1;
    private Long nextEventOption2;
    private int moneyOption1 = 0;
    private int moneyOption2 = 0;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public Long getNextEventOption1() {
        return nextEventOption1;
    }

    public void setNextEventOption1(Long nextEventOption1) {
        this.nextEventOption1 = nextEventOption1;
    }

    public Long getNextEventOption2() {
        return nextEventOption2;
    }

    public void setNextEventOption2(Long nextEventOption2) {
        this.nextEventOption2 = nextEventOption2;
    }

    public int getMoneyOption1() {
        return moneyOption1;
    }

    public void setMoneyOption1(int moneyOption1) {
        this.moneyOption1 = moneyOption1;
    }

    public int getMoneyOption2() {
        return moneyOption2;
    }

    public void setMoneyOption2(int moneyOption2) {
        this.moneyOption2 = moneyOption2;
    }
}
