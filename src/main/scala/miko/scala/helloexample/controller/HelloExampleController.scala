package miko.scala.helloexample.controller

import miko.scala.helloexample.service.{ExampleImportService, ExampleService}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.{ModelMap, Model}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import org.springframework.web.servlet.ModelAndView

/**
 * @author kopeckymiroslav
 */

@Controller
@RequestMapping(Array("/"))
class HelloExampleController @Autowired() (exampleService: ExampleService, exampleImportService: ExampleImportService){

  private val logger = LoggerFactory.getLogger(getClass)

  @RequestMapping(method =  Array(RequestMethod.GET))
  def printMain( model: ModelAndView): ModelAndView = {

    logger.info("Info Test")
    logger.debug("Debug Test")
    logger.error("Error Test")

    model.addObject("message", "Here is Scala with ServiceName = " + exampleService.serviceName)
    model.addObject("importMessage", "Here is Scala with ServiceImportName = " + exampleImportService.name)
    model.setViewName("main")
    model
  }

  @RequestMapping(method =  Array(RequestMethod.GET), value = Array[String]{"/test/web"})
  def printTest(model: ModelMap): String = {
    logger.info("PrintTest Start")
    "test"
  }
}
