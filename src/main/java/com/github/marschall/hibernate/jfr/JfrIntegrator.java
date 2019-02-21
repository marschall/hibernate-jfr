package com.github.marschall.hibernate.jfr;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class JfrIntegrator implements Integrator {

  @Override
  public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory,
      SessionFactoryServiceRegistry serviceRegistry) {

    var eventListenerRegistry =
        serviceRegistry.getService(EventListenerRegistry.class);

    var listener = new JfrListener();
    eventListenerRegistry.getEventListenerGroup(EventType.AUTO_FLUSH)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.CLEAR)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.DELETE)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.DIRTY_CHECK)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.EVICT)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.FLUSH)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.FLUSH_ENTITY)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.LOAD)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.LOCK)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.MERGE)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.PERSIST)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.PERSIST_ONFLUSH)
    .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.REFRESH)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.RESOLVE_NATURAL_ID)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.SAVE)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.SAVE_UPDATE)
      .appendListener(listener);
    eventListenerRegistry.getEventListenerGroup(EventType.UPDATE)
      .appendListener(listener);
  }

  @Override
  public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

  }

}
