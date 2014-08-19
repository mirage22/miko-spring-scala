package miko.scala.helloexample.service

import org.springframework.stereotype.Service

/**
 * @author kopeckymiroslav
 */

@Service("exampleService")
class ExampleServiceImpl extends ExampleService{
  override def serviceName: String = "ExampleServiceName"
}
