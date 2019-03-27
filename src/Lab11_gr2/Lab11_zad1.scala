package Lab11_gr2

object Lab11_zad1 {
  def main(args: Array[String]): Unit = {
    val in = List(List(1, 2, 3, 4),
      List(5, 0, -1, 7),
      List(-1, 51, 1, 0),
      List(0, 0, 7, 7))

    println("The biggest number: ")
    println((in.maxBy(_.max)).max)

    println("The collection containing biggest number: ")
    println(in.maxBy(_.max))

    println("The collection containing the biggest numbers: ")

     val max = for( a <- Range(0,in.length)) yield {
      in(a).max
    }
    println(max.toList)


    def indicate(list: List[List[Int]],partialFunction: PartialFunction[Int,Boolean] ):List[Boolean] ={
      list.flatMap(_.collect(partialFunction))
    }
    println( indicate( in, {case x if x < 0 => true} ) )
    // List(true, true) // two negative values

    def synchForEach[T](list: List[List[Int]], fun: List[Int] => T): List[T] ={
//      val cos = for(i <- Range(0,list.length)) yield {
//        fun(List(list(0).apply(i),list(1).apply(i),list(2).apply(i),list(3).apply(i)))
//      }
      list.transpose.map(fun)
    }
    println( synchForEach( in, { x => x } ) )
    // List(List(1, 5, -1, 0), List(2, 0, 51, 0), List(3, -1, 1, 7), List(4, 7, 0,7)) // transposition
    println( synchForEach( in, { x => x.max } ) )
    // List(5, 51, 7, 7) // max in each “column”
  }

}
