##### A list of core implementations vs a list of enterprise specifications

Java SE (Core Developer Technologies) | Examples | Java EE (Enterprise Developer Technologies) | Examples
------------- | ------------- | ------------- | -------------
[HttpServer](http://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/HttpServer.html) | [view example](https://github.com/ThreaT/Java-SE-8-vs-Java-EE-7-Specifications/tree/master/src/main/java/com/java/se/webserver) | [Servlets](https://docs.oracle.com/javaee/7/api/javax/servlet/package-summary.html) | -
[JEP 110](https://bugs.openjdk.java.net/browse/JDK-8042950)  | - | [Websocket](https://docs.oracle.com/javaee/7/api/javax/websocket/package-summary.html) | -
[SQL](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)  | [view example](https://github.com/ThreaT/Java-SE-8-vs-Java-EE-7-Specifications/tree/master/src/main/java/com/java/se/database) | [Persistence](https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html) | -
[Queue](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)  | - | [JMS](https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html) | -
[HttpServer](http://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/HttpServer.html), [JEP 198](http://openjdk.java.net/jeps/198), [SAX](https://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/SAXParser.html), [DOM](https://docs.oracle.com/javase/8/docs/api/org/w3c/dom/package-summary.html) | - | [JAX-RS](http://docs.oracle.com/javaee/7/api/) | -

##### A list of core implementation frameworks vs a list of enterprise implementation frameworks

Core Framework | Implementations | Enterprise Frameworks | Implementations
------------- | ------------- | ------------- | -------------
sweven | HttpServer, SQL | Spring MVC | Servlets, JMS, JAX-RS
cathexis | - | Struts | el, Faces
- | - | JSF | el, Faces

[More](https://en.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition) data needs to be added. Contributions welcome.
