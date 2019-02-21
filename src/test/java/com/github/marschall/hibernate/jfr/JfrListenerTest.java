package com.github.marschall.hibernate.jfr;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
  void find() {
    var first = this.entityManager.find(Post.class, BigInteger.valueOf(1L));
    first.setTitle("erstor");
  }

  @Test
  void delete() {
    var first = this.entityManager.find(Post.class, BigInteger.valueOf(1L));
    this.entityManager.remove(first);
  }

  @Test
  void detach() {
    var first = this.entityManager.find(Post.class, BigInteger.valueOf(1L));
    this.entityManager.detach(first);
  }

  @Test
  void update() {
    var first = this.entityManager.find(Post.class, BigInteger.valueOf(1L));
    first.setTitle("Updated: " + first.getTitle());
  }

  @Test
  void merge() {
    var second = new Post();
    second.setId(BigInteger.valueOf(2L));
    second.setTitle("close but no cigar");
    var merged = this.entityManager.merge(second);

    assertNotNull(merged);
  }

  @Test
  void persist() {
    var post3 = new Post();
    post3.setId(BigInteger.valueOf(3L));
    post3.setTitle("Book 3");

    this.entityManager.persist(post3);
  }

}
