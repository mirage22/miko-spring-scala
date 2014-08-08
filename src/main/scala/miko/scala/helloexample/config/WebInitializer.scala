package miko.scala.helloexample.config

import javax.servlet.ServletContext
import javax.servlet.ServletRegistration.Dynamic

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

/**
 * @author kopeckymiroslav
 */
class WebInitializer extends WebApplicationInitializer{

  override def onStartup(servletContext: ServletContext) = {
    val ctx = new AnnotationConfigWebApplicationContext
    ctx.register(classOf[WebConfig])

    ctx.setConfigLocation("META-INF/spring/app-spring-scala.xml")

    val servlet: Dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx))
    servlet.addMapping("/")
    servlet.setLoadOnStartup(1)
  }
}
