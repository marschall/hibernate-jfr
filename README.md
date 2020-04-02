Hibernate JFR [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/hibernate-jfr/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/hibernate-jfr) [![Javadocs](https://www.javadoc.io/badge/com.github.marschall/hibernate-jfr.svg)](https://www.javadoc.io/doc/com.github.marschall/hibernate-jfr) [![Build Status](https://travis-ci.org/marschall/hibernate-jfr.svg?branch=master)](https://travis-ci.org/marschall/hibernate-jfr)
=============

A Hiberante listener that generates JFR events.

Usage
-----

The project uses a Hibernate integrator so simply adding the dependency

```xml
<dependency>
  <groupId>com.github.marschall</groupId>
  <artifactId>hibernate-jfr</artifactId>
  <version>0.3.0</version>
</dependency>
```

And set the `hibernate.session_factory.statement_inspector` propert to `com.github.marschall.hibernate.jfr.JfrStatementInspector` for example using

```xml
<property name="hibernate.session_factory.statement_inspector" value="com.github.marschall.hibernate.jfr.JfrStatementInspector" />
```


You can generate a flight recording using something like this

```
-XX:StartFlightRecording:filename=recording.jfr
-XX:FlightRecorderOptions:stackdepth=256
```

