package miko.scala.helloexample.service

import org.springframework.stereotype.Service

/**
 * @author kopeckymiroslav
 */
@Service("exampleImportService")
class ExampleImportServiceImpl extends ExampleImportService{
  override def name: String = "Imported service over XML"
}
