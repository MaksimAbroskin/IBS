package task_2.csv

import java.io.{BufferedWriter, File, FileWriter}
import scala.util.{Failure, Success, Using}

case class CsvHandler(path: String, delimiter: String) {
  var content: Array[Array[String]] = Array.empty
  var headers: Array[String] = Array.empty

  def readFile(): Either[ErrorMessage, CsvHandler] = {
    val lines = Using(scala.io.Source.fromFile(path)) {source =>
      source.getLines().toArray
    }

    lines match {
      case Failure(_) => Left(FileNotExistsErrorMessage(path))
      case Success(lines) =>
        if (lines.nonEmpty) {
          val splitted = lines.map(_.split(delimiter).map(_.trim))
          headers = splitted.headOption.getOrElse(Array.empty)
          content = splitted.tail
        }
        Right(this)
    }
  }

  def addColumn(colName: String, values: List[String]): CsvHandler = {
    headers :+= colName
    val limit = math.min(content.length, values.length)
    for (i <- 0 until limit) {
      content(i) :+= values(i)
    }
    this
  }

  def addRow(row: String): CsvHandler = {
    content :+= row.split(delimiter).map(_.trim)
    this
  }

  def saveFile(): Unit = {
    val file = new File(path)
    val linesContent = content.map(_.mkString(delimiter))
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(headers.mkString(delimiter) + "\n")
    for (line <- linesContent) {
      bw.write(line + "\n")
    }
    bw.close()
  }

}
