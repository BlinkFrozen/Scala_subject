package Lab1_gr

object Lab1_zad1 {
  def main(args: Array[String]): Unit = {

    if(args.length < 1){
      println("EROOR")
      System.exit(0)
    }
    else if(args.length == 1){
      val end = args(0).toInt
      val x = (0 to end).toList
      x.foreach(print)
    }
    else if(args.length == 2){
      val end = args(1).toInt
      val beg = args(0).toInt
      val x = (beg to end).toList
      x.foreach(println)
    }
  }
}
