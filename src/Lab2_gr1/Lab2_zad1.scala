package Lab2_gr1

object Lab2_zad1 {
  def main(args: Array[String]): Unit = {
    if(args.length == 1) {
      FizzleBang(args(0).toInt)
    }
    else{
      FizzleBang()
    }
  }

  def FizzleBang(x:Int = 20)={
    val l = (1 to x).toList
    l.foreach( l => {
      if(l%3 == 0 && l%5 == 0) {
        println("Fizz Buzz")
      }
      else if(l % 3 == 0 ){
        println("Fizz")
      }
      else if(l%5 ==0){
        println("Buzz")
      }
      else{
        println(l)
      }
    })
  }
}
