name := "miko-spring-scala"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-webmvc" % "4.0.6.RELEASE",
  "org.springframework" % "spring-context" % "4.0.6.RELEASE",
  "org.springframework" % "spring-context-support" % "4.0.6.RELEASE",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "javax.servlet" % "jstl" % "1.2" % "compile",
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container, compile",
  "org.eclipse.jetty" % "jetty-jsp" % "9.1.0.v20131115" % "container"
)

jetty(port = 9090)