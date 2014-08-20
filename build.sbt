name := "miko-spring-scala"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-webmvc" % "4.0.6.RELEASE",
  "org.springframework" % "spring-context" % "4.0.6.RELEASE",
  "org.springframework" % "spring-context-support" % "4.0.6.RELEASE",
  "org.apache.tiles" % "tiles-jsp" % "3.0.4",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "javax.servlet" % "jstl" % "1.2" % "compile",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.5" ,
  "org.slf4j" % "slf4j-api" % "1.7.5" ,
  "org.slf4j" % "slf4j-log4j12" % "1.7.5",
  "log4j" % "log4j" % "1.2.17" excludeAll(
        ExclusionRule(organization = "com.sun.jdmk"),
        ExclusionRule(organization = "com.sun.jmx"),
        ExclusionRule(organization = "javax.jms")
      ),
  "org.apache.tomcat.embed" % "tomcat-embed-core" % "7.0.55" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "7.0.55" % "container",
  "org.apache.tomcat.embed" % "tomcat-embed-jasper" % "7.0.55" % "container"
)

tomcat(port = 9090)