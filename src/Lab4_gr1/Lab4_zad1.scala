package Lab4_gr1
import scala.math.pow
import scala.annotation.tailrec

object Lab4_zad1 {
  def main(args: Array[String]): Unit = {
    val sum1 = sumfrac(3, 1e-3 )
    val sum2 = sumfrac(5, 1e-9 )
    println(sum1)
    println(sum2)
  }

  def sumfrac(x: Int, d: Double): Double = {
    var sum = 0.0

    @tailrec
    def liczymy(i:Int = 0):Double = {
      if(fraction(x,i+1) < d)
        sum
      else{
        sum = sum + fraction(x,i)
//        println(sum)
        liczymy(i+1)
      }
    }
    println()
    liczymy()
  }

  def fraction(x:Double,n:Double):Double = 1/pow(x,n)
}
