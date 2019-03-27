package Lab4_gr2
import scala.annotation.tailrec
import scala.math.abs

object Lab4_zad2 {
  def main(args: Array[String]): Unit = {
    val c = closest( 1, 17, 8, 27, 21, 29, 99, 22 , 4)
    println("" + c._1 + " " + c._2 )
  }



  def closest(args: Int*):(Int,Int)={

    val numbers = args.toList

    @tailrec
    def ClosestOneRecursion(chechPointIndex: Int, result:(Int,Int) = (Int.MinValue,Int.MaxValue),bestDistance: Int = Int.MaxValue, current:Int = 0): (Int,Int)  = {
      if(current == numbers.length){
        result
      }
      else {
        val curDistance = countDistance(numbers(chechPointIndex),numbers(current))
        if(chechPointIndex != current && curDistance < bestDistance) {
          ClosestOneRecursion(chechPointIndex, (numbers(chechPointIndex), numbers(current)), curDistance, current + 1)
        }
        else {
          ClosestOneRecursion(chechPointIndex, result, bestDistance, current + 1)
        }
      }
    }

    @tailrec
    def closestRecursive(result:(Int,Int) = (Int.MinValue,Int.MaxValue),bestDistance: Int = Int.MaxValue,current: Int = 0):(Int,Int) = {
      if (numbers.length == current) {
        result
      }
      else{
        val resultCurrent = ClosestOneRecursion(current)
        val resultDistance = countDistance(resultCurrent._1,resultCurrent._2)

        if(resultDistance < bestDistance) {
          closestRecursive(resultCurrent,resultDistance,current+1)
        }
        else {
          closestRecursive(result, bestDistance, current + 1)
        }
      }
    }
    closestRecursive()
   }

  def countDistance(i: Int, i1: Int): Int ={
    abs(i-i1)
  }
}
