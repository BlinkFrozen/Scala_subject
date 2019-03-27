package Lab6_gr2
import scala.annotation.tailrec

object Lab6_zad1 {
  def main(args: Array[String]): Unit = {

    val li = List(1, 4, 3, 4, 52, 3, 2)
    val npos1 = forel(li)(_ < 5) {
      println("<3")
    } {
      println(" not <3 ")
    }
    println(npos1)
    val npos2 = forel(li)(_ % 3 == 0) {
      println("divisble by 3")
    } {
      println(" not divisible 3")
    }
    println(npos2)

  }

  @tailrec
  def forel(list: List[Int], result: Int = 0)(condition: Int => Boolean)(goodscrypt: => Unit)(badscrypt: => Unit): Int = {

    if (!list.isEmpty)
    {
      if (condition(list.head)) {
        goodscrypt
        forel(list.tail, result + 1)(condition)(goodscrypt)(badscrypt)
      }
      else{
        badscrypt
        forel(list.tail,result)(condition)(goodscrypt)(badscrypt)
      }
    }
    else result
  }
}