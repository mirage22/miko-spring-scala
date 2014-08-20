package miko.scala.helloexample.config

import java.util.Locale

import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.context.annotation.{FilterType, Configuration, Bean, ComponentScan}
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.http.MediaType
import org.springframework.stereotype.{Service, Controller}
import org.springframework.web.servlet.{LocaleResolver, ViewResolver}
import org.springframework.web.servlet.config.annotation._
import org.springframework.web.servlet.i18n.{CookieLocaleResolver, LocaleChangeInterceptor}
import org.springframework.web.servlet.view.tiles3.{TilesConfigurer, TilesViewResolver}


/**
 * @author kopeckymiroslav
 */

@Configuration
@ComponentScan(basePackages = Array("miko.scala.helloexample"), useDefaultFilters = false, includeFilters = Array(
  new ComponentScan.Filter(`type` = FilterType.ANNOTATION,
    value = Array(classOf[Controller], classOf[Service]))))
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter{

  private val logger = LoggerFactory.getLogger(getClass)

  override def configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) = {
    configurer.enable()
  }

  override def addViewControllers(registry: ViewControllerRegistry): Unit ={
    registry.addViewController("/")
  }

  @Bean
  def getTilesViewResolver: ViewResolver = {
    val resolver:TilesViewResolver = new TilesViewResolver()
    resolver.setContentType("text/html")
    resolver
  }

  @Bean
  def getTilesConfigurer: TilesConfigurer = {
    val configurer:TilesConfigurer = new TilesConfigurer()
    configurer.setCheckRefresh(true)
    configurer.setDefinitions({"/WEB-INF/pages/tiles.xml"})
    configurer
  }

  override def addInterceptors(registry:InterceptorRegistry) = {
    val localeChangeInterceptor = new LocaleChangeInterceptor()
    localeChangeInterceptor.setParamName("lang")
    registry.addInterceptor(localeChangeInterceptor)
  }

  /**
   * equivalents for <mvc:resources/> tags
   * @param registry
   */
  override def addResourceHandlers(registry: ResourceHandlerRegistry) = {
    logger.debug("Resources HANDLER")
    registry.addResourceHandler("/app/**").addResourceLocations("/app/").setCachePeriod(31550522)
    registry.addResourceHandler("/WEB-INF/layouts/**").addResourceLocations("/WEB-INF/layouts/").setCachePeriod(31550522);
    registry.addResourceHandler("/WEB-INF/pages/template/**").addResourceLocations("/WEB-INF/pages/template/").setCachePeriod(31550522);
  }

  @Bean(name = Array("localeResolver"))
  def getLocaleResolver: LocaleResolver = {
    val cookieLocaleResolver: CookieLocaleResolver = new CookieLocaleResolver()
    cookieLocaleResolver.setDefaultLocale(new Locale("en"))
    cookieLocaleResolver
  }

  override def configureContentNegotiation(configurer: ContentNegotiationConfigurer) = {
    configurer.favorPathExtension(true).ignoreAcceptHeader(true)
        .useJaf(false).defaultContentType(MediaType.TEXT_HTML)
        .mediaType("html", MediaType.TEXT_HTML)
        .mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("json", MediaType.APPLICATION_JSON)
  }

  @Bean(name = Array("messageSource"))
  def getMessageSource: MessageSource = {
    val msgSrc:ReloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource()
    msgSrc.setBasename("classpath:/messages/message")
    msgSrc
  }

//  @Bean
//  def viewResolver = {
//    val viewResolver = new InternalResourceViewResolver
//    viewResolver.setViewClass(classOf[JstlView])
//    viewResolver.setPrefix("/WEB-INF/pages/")
//    viewResolver.setSuffix(".jsp")
//    viewResolver
//  }
}
