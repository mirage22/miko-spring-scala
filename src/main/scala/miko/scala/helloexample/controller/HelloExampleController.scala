package miko.scala.helloexample.controller

import miko.scala.helloexample.service.{ExampleImportService, ExampleService}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.{ModelMap, Model}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

/**
 * @author kopeckymiroslav
 */

@Controller
@RequestMapping(Array("/"))
class HelloExampleController @Autowired() (exampleService: ExampleService, exampleImportService: ExampleImportService){

  private val logger = LoggerFactory.getLogger(getClass)

  @RequestMapping(method =  Array(RequestMethod.GET))
  def hello( model: ModelMap): String = {

    logger.info("Info Test")
    logger.debug("Debug Test")
    logger.error("Error Test")

//    model.addAttribute("message", "Here is Scala with ServiceName = TEST22" )
    model.addAttribute("message", "Here is Scala with ServiceName = " + exampleService.serviceName)
//    model.addAttribute("importMessage", "Here is Scala with ServiceImportName = TEST1" )
    model.addAttribute("importMessage", "Here is Scala with ServiceImportName = " + exampleImportService.name)
    "main"
  }

  @RequestMapping(method =  Array(RequestMethod.GET), value = Array[String]{"/test/web"})
  def printTest(model: ModelMap): String = {
    logger.info("PrintTest Start")
    "test"
  }
}
