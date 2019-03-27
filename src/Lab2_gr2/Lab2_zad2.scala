package Lab2_gr2
import scala.util.Random
import scala.math.sqrt
import scala.math.pow

object Lab2_zad2 {
  def main(args: Array[String]): Unit = {

  }

  def Point() = (Random.nextInt(),Random.nextInt())

  def Distance(x:(Int,Int),y:(Int,Int))= sqrt(pow(x._1 - y._2,2) + pow(x._2 - y._2,2))


}
