package Lab5_gr2
import scala.annotation.tailrec
import scala.math.abs

object Lab5_zad1 {
  def main(args: Array[String]): Unit = {

    redux( 1,7,8,9,10)( _+_ ) // == 35
    //which is (((1+7)+8)+8)+… or
    redux( 2,-4,5,-2,4)( _*abs(_) ) // == 320

  }


  def redux(args: Int*)(fun:(Int,Int) => Int)={

    val list = args.toArray

    @tailrec
    def calculate(sum:Int , k:Int,distance:Int = 1):Int ={
      if(distance + 1 == list.length){
        fun(sum,k)
      }
      else{
        calculate(fun(sum,k),list(distance + 1),distance + 1)
      }
    }

    println(calculate(list(0),list(1)))
  }
}
