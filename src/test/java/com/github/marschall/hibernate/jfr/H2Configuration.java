package com.github.marschall.hibernate.jfr;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionOperations;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class H2Configuration {

  private static final AtomicInteger COUNT = new AtomicInteger();

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
         // the spring test context framework keeps application contexts
         // and thus databases around for the entire VM lifetime
         // so be have to create a unique name here to avoid sharing
         // between application contexts
        .setName("H2-" + COUNT.incrementAndGet())
        .setType(H2)
        .addScript("h2-schema.sql")
        .addScript("h2-data.sql")
        .build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setPersistenceUnitName("threeten-jpa-hibernate-h2");
    bean.setJpaDialect(this.jpaDialect());
    bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    bean.setDataSource(dataSource);
    return bean;
  }

  @Bean
  public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
    transactionManager.setDataSource(this.dataSource());
    transactionManager.setJpaDialect(this.jpaDialect());
    return transactionManager;
  }

  @Bean
  public JpaDialect jpaDialect() {
    return new HibernateJpaDialect();
  }

  @Bean
  public TransactionOperations transactionOperations(PlatformTransactionManager txManager) {
    TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    return new TransactionTemplate(txManager, transactionDefinition);
  }

}
