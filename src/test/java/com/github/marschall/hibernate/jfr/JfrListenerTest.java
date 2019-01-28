package com.github.marschall.hibernate.jfr;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = H2Configuration.class)
class JfrListenerTest {

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  void test() {
    assertNotNull(this.entityManager);
  }

}
