package task_2

class Shape(numCorners: Int) {
  def getNumFacets: Int = this.numCorners

  def calc: Int = {
    2 * this.numCorners
  }
}

object Shape {
  def apply(n: Int): Shape = {
    if (n <= 2) throw new IllegalArgumentException("Incorrect number of corners. Must be >= 3")
    new Shape(n)
  }
}
