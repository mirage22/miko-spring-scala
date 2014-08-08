package miko.scala.helloexample.controller

import miko.scala.helloexample.service.{ExampleImportService, ExampleService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMethod, RequestMapping}

/**
 * @author kopeckymiroslav
 */

@Controller
@RequestMapping(Array("/"))
class HelloExampleController @Autowired() (exampleService: ExampleService, exampleImportService: ExampleImportService){

  @RequestMapping(method =  Array(RequestMethod.GET))
  def hello( model: Model) = {
    model.addAttribute("message", "Here is Scala with ServiceName = " + exampleService.serviceName)
    model.addAttribute("importMessage", "Here is Scala with ServiceImportName = " + exampleImportService.name)
    "hello"
  }
}
