package com.ranjit.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {
    @Autowired @Qualifier("mi")
    private Team home;

    @Autowired @Qualifier("csk")
    private Team away;

    public Game() {
    }

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    @Override
    public String toString() {
        return "Game{" +
                "home=" + home +
                ", away=" + away +
                '}';
    }
}
