package Lab5_gr1
import scala.annotation.tailrec

object Lab5_zad1 {
  def main(args: Array[String]): Unit = {

    var x = -5
    repeatUntil{  x = x +1; println(x); x  }{ _ <= 0  }
    repeatUntil{  x = x -3; println(x); x  }{ _ > -10  }
    repeatUntil{  x = x +7; println(x); x  }{ (i:Int) => i < 20  }

  }
  @tailrec
  def repeatUntil(x: => Int)(condition: Int => Boolean){

    if(condition(x)){
      repeatUntil(x)(condition)
    }
  }
}
