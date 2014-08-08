package miko.scala.helloexample.config

import org.springframework.context.annotation.{Configuration, Bean, ComponentScan}
import org.springframework.web.servlet.config.annotation.{DefaultServletHandlerConfigurer, ResourceHandlerRegistry, EnableWebMvc, WebMvcConfigurerAdapter}
import org.springframework.web.servlet.view.{InternalResourceViewResolver, JstlView}

/**
 * @author kopeckymiroslav
 */

@Configuration
@ComponentScan(basePackages = Array("miko.scala.helloexample"))
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter{

  override def addResourceHandlers(registry: ResourceHandlerRegistry) = {
    registry.addResourceHandler("/app/**").addResourceLocations("/app/").setCachePeriod(31550522)
  }

  override def configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) = {
    configurer.enable()
  }

  @Bean
  def viewResolver = {
    val viewResolver = new InternalResourceViewResolver
    viewResolver.setViewClass(classOf[JstlView])
    viewResolver.setPrefix("/WEB-INF/pages/")
    viewResolver.setSuffix(".jsp")
    viewResolver
  }
}
