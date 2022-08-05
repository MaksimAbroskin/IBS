package task_2

import task_2.csv.CsvHandler

object Main extends App {
  val csvHandler = CsvHandler("src/main/resources/testCsv.csv", ";")

  csvHandler.readFile().map(_.addRow("c; 3; c_4").addColumn("col4", List("z_1")).saveFile()) match {
    case Left(err) => println(err.message)
    case Right(_) => ()
  }

}
