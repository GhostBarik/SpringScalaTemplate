package com.template.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Config for application persistence layer
 */
@Configuration
@PropertySource("classpath:/config.properties")
@EnableJpaRepositories(basePackages = {"com.template.repository"})
@EnableTransactionManagement
public class JpaConfig {

    /**
     * configuration parameters from `config.properties`
     */
    @Autowired
    private Environment environment;


    /**
     * Data source (database)
     */
    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    /**
     * Hibernate entity manager factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();

        lcemfb.setDataSource(dataSource());
        lcemfb.setPackagesToScan("com.template.model");
        lcemfb.setPersistenceUnitName("MyPersistenceUnit");
        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(va);

        // configure JPA entity manager by setting properties from configuration file `config.properties`

        Properties ps = new Properties();

        ps.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        ps.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        ps.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        ps.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));

        lcemfb.setJpaProperties(ps);
        lcemfb.afterPropertiesSet();

        return lcemfb;
    }

    /**
     * Spring transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
