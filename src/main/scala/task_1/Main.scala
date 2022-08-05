package task_1

object Main extends App {
  val range = 1 to 100

  def brutePrint(): Unit = {
    range.foreach(x => println {
      if (x % 15 == 0) "FizzBuzz"
      else if (x % 5 == 0) "Buzz"
      else if (x % 3 == 0) "Fizz"
      else x.toString
    }
    )
  }

  def prettyBrutePrint(): Unit = {
    range.foreach { x =>
      println {
        (x % 3, x % 5) match {
          case (0, 0) => "FizzBuzz"
          case (0, _) => "Fizz"
          case (_, 0) => "Buzz"
          case _ => x.toString
        }
      }
    }
  }

  def fastPrint(): Unit = {
    val default = (1 to 15).map(x =>
      if (x % 15 == 0) "FizzBuzz"
      else if (x % 5 == 0) "Buzz"
      else if (x % 3 == 0) "Fizz"
      else x.toString
    )
    range.foreach(x => println(default((x - 1) % 15)))
  }

  brutePrint()

}
