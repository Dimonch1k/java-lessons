package org.example.lesson2;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class AppConfig
{
  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName( "org.postgresql.Driver" );
    dataSource.setJdbcUrl( "jdbc:postgresql://localhost:5433/java-lessons" );
    dataSource.setUsername( "postgres" );
    dataSource.setPassword( "postgres" );
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
    DataSource dataSource )
  {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource( dataSource );
    em.setPackagesToScan( "org.example.lesson2.db.entity" );
    em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
    return em;
  }

  @Bean
  public JpaTransactionManager transactionManager(
    LocalContainerEntityManagerFactoryBean entityManagerFactory )
  {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory( entityManagerFactory.getObject() );
    return transactionManager;
  }
}