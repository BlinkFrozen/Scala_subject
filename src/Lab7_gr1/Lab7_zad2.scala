package Lab7_gr1

object Lab7_zad2 {
  def main(args: Array[String]): Unit = {
    val x = Int*5
    println( x.getClass.getSimpleName + x.mkString(" ") )
    // expected output  int[]0 0 0 0 0
  }

  implicit def toArray(x:Int) = Array.ofDim[Int](x)

  object Int{
    def *(x:Int):Array[Int] = x
  }
}
