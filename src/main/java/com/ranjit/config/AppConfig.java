package com.ranjit.config;

import com.ranjit.dao.AccountRepository;
import com.ranjit.dao.JdbcAccountRepository;
import com.ranjit.model.Game;
import com.ranjit.model.MyBean;
import com.ranjit.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.text.NumberFormat;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan (basePackages = "com.ranjit")
public class AppConfig {

    @Bean
    @Scope(value="singleton")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setProperty(cf());
        return myBean;
    }

    @Autowired
    private Environment env;

    @Bean @Scope("prototype")
    public Game game(){
        return new Game(mi(), csk());
    }

    @Bean
    public Team mi(){
        return new Team("MI");
    }

    @Bean
    public Team csk(){
        return new Team("CSK");
    }

    @Bean(name = "datasource", destroyMethod = "shutdown")
    @Profile("test")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();
    }

    @Bean
    @Profile("test")
    public AccountRepository jdbcAccountRepository(){
        return new JdbcAccountRepository(dataSource());
    }

    @Bean
    public NumberFormat cf(){
        return NumberFormat.getCurrencyInstance();
    }
}
