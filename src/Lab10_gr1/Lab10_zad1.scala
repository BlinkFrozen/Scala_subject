package Lab10_gr1

object Lab10_zad1 {

  def repeated(l: List[Int]): List[Int] ={
    l.foldLeft(Map.empty[Int,Int])((acc,value) => {
      acc.updated(value,acc.getOrElse(value,0) + 1)
    }).filter(_._2 > 1 ).keys.toList
  }

  def condMerge(list: List[Int], vector: Vector[Int], value: ((Int,Int)) => Int):List[Int] ={
    list.zip(vector).filter(tp1 => tp1._1 > 0 && tp1._2 > 0).map(tp1 => value(tp1))
  }

  def main(args: Array[String]): Unit = {
    println(repeated(List(-8,5,6,1,4,4,2,5,-1,9,9)))
    //List(5, 9, 4)
    import math.max
    val m = condMerge(List(2,-9,1,8), Vector(3,-2,45,2),
      {
        case x: Tuple2[Int,Int] if max(x._1, x._2) > 0 => max(x._1,x._2)
      } )
    println(m)
    // List(3, 45, 8)
  }

}
