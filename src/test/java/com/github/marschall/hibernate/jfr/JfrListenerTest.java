package com.github.marschall.hibernate.jfr;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = H2Configuration.class)
@Transactional
class JfrListenerTest {

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  void test() {
    var post = new Post();
    post.setId(BigInteger.valueOf(3L));
    post.setTitle("Book 3");

    this.entityManager.persist(post);
  }

}
