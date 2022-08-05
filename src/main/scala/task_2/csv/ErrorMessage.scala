package task_2.csv

sealed trait ErrorMessage {
  val message: String
}

case class FileNotExistsErrorMessage(path: String) extends ErrorMessage {
  override val message: String = s"File \"$path\" not exists"
}
