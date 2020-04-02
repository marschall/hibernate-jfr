package com.github.marschall.hibernate.jfr;

import org.hibernate.resource.jdbc.spi.StatementInspector;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;

/**
 * Listens for Hibernate SQL statment execution and logs them.
 */
public final class JfrStatementInspector implements StatementInspector {

  @Override
  public String inspect(String sql) {
    var event = new JfrStatementEvent();
    event.sql = sql;
    event.commit();
    return null;
  }

  @Label("Statement")
  @Description("A SQL statement execution")
  @Category("Hibernate")
  static class JfrStatementEvent extends Event {

    @Label("SQL")
    @Description("The SQL statement that was executed")
    private String sql;

  }

}
