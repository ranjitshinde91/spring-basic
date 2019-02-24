package com.ranjit.config;

import com.ranjit.dao.AccountRepository;
import com.ranjit.dao.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan(basePackages = "com.ranjit")
@Configuration
@PropertySource("classpath:prod.properties")
@Import(AppConfig.class)
@Profile("test")
public class JPAConfig {
    @Autowired
    private Environment env;
    private DataSource dataSource;

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.H2);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){

        Properties props = new Properties();
        props.setProperty("hibernate.format_sql", String.valueOf(true));

        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.ranjit.model");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setJpaProperties(props);

        return emf;
    }

    @Bean
    @Profile("test")
    public AccountRepository jpaAccountRepository(){
        return new JpaAccountRepository();
    }

    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }




}
