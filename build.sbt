name := """sofi-homework"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaCore,
  javaJdbc,
  javaWs % "test",
  "com.h2database" % "h2" % "1.4.181" withJavadoc(),
  "org.springframework" % "spring-context" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-jdbc" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-tx" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-aop" % "4.1.1.RELEASE" withJavadoc(),
  "org.springframework" % "spring-test" % "4.1.1.RELEASE" % "test" withJavadoc(),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "mysql" % "mysql-connector-java" % "5.1.27"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)
