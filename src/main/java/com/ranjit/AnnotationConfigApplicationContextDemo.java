package com.ranjit;

import com.ranjit.config.AppConfig;
import com.ranjit.model.Game;
import com.ranjit.model.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;

public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            // System.out.println(beanDefinitionName);
        }

        Team mi = context.getBean("mi", Team.class);
        System.out.println(mi.getName());

        Team csk = context.getBean("csk", Team.class);
        System.out.println(csk.getName());

        Game game = context.getBean("game", Game.class);
        game.setAway(mi);
        game.setHome(csk);
        System.out.println(game);

        Game game2 = context.getBean("game", Game.class);
        game2.setAway(csk);
        game2.setHome(mi);
        System.out.println(game2);

        NumberFormat cf = context.getBean("cf", NumberFormat.class);
        System.out.println(cf.format(123));

    }
}
