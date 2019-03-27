package Lab2_gr1
import scala.util.Random
import scala.math.sqrt
import scala.math.pow

object Lab2_zad2 {
  def main(args: Array[String]): Unit = {
    def Point:(Double,Double) = (Random.nextDouble(),Random.nextDouble())

    @scala.annotation.tailrec def Total_Distance(list:List[(Double,Double)],i:Int,sum:Int = 0): Int = {
      if(i == 0) sum else Total_Distance(list,i-1,sum + Distance(list(i-1)))
    }
    def Distance(x:(Double,Double)) :Int = if(sqrt(pow(x._1,2) + pow(x._2,2)) > 1) 0 else 1

    val N = 100000

    val list = List.range(1,N).map(_ => Point)
    val sum = Total_Distance(list,N-1)
    println(sum)
    println(N)
    val pie = 4.0*(sum.toFloat/N.toFloat)
    println(pie)



  }


}
