package com.ranjit;

import com.ranjit.model.Game;
import com.ranjit.model.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

public class XmlConfigApplicationContext {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Team mi = context.getBean("mi", Team.class);
        System.out.println(mi.getName());

        Team csk = context.getBean("csk", Team.class);
        System.out.println(csk.getName());

        Game game = context.getBean("game", Game.class);
        game.setAwayTeam(mi);
        game.setHomeTeam(csk);
        System.out.println(game);

        Game game2 = context.getBean("game", Game.class);
        game2.setAwayTeam(csk);
        game2.setHomeTeam(mi);
        System.out.println(game2);

        NumberFormat cf = context.getBean("cf", NumberFormat.class);
        System.out.println(cf.format(123));
    }
}
