package Lab4_gr3

object Lab4_zad1 {
  def main(args: Array[String]): Unit = {
//    println( mid( (3,5) )(1) )
//    println( mid( (3,5) )(8) )
//    println( mid( (9,5) )(8) )
//    val fixedMid = mid( (0,100) )
//    println( fixedMid(200) )
//    println( fixedMid(2) )
    @@( "Hello" )()
    @@( "abc" )(4)
    @@()(2) // twice the empty line
    @@( "abc" )()
    def add_<( arg: String ) = "<"+arg
    def add_>( arg: String ) = arg+">"
    val wrap = compose2( add_<, add_>)
    println( wrap( "hello") )
  }

  def @@(args: String = "")(i: Int = 1): Unit = {
    for(e<-Range(0,i)){
      println(args)
    }
  }

  def compose2(stringToString: String => String, stringToString1: String => String): String => String={

    x:String => stringToString + x + stringToString1

  }
}
