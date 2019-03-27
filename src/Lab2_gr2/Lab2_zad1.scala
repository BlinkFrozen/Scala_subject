package Lab2_gr2

object Lab2_zad1 {
  def main(args: Array[String]): Unit = {
    val test = Array.ofDim[Double](4,5)
    for(i <- 0 until 4; j<- 0 until 5) test(i)(j) = i/(1+j)
    print2DArr(test,4)
    print2DArr(test,5)
  }

  def print2DArr(arr:Array[Array[Double]],formatter:Int): Unit = {
    arr.foreach(x => println(formatNumbers(x,formatter)))
  }

  def formatNumbers(num:Array[Double],formatter:Int): String = {
    num.map(_.formatted(s"%.${formatter}f")).mkString(" ").concat("\n")
  }
}
