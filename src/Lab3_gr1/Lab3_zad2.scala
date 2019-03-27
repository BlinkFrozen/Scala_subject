package Lab3_gr1

object Lab3_zad2 {
  def main(args: Array[String]): Unit = {
    minmax( List(1,3,4,5,2,9,4,5,-1,5,6,6) ) // results in tuple (-1,9)
  }

  def minmax(list:List[Int]): Unit ={

    var result1 = Int.MaxValue
    var result2 = Int.MinValue
    @scala.annotation.tailrec
    def find(iThinkTheBest:List[Int],i:Int = 0):(Int,Int) = {
      if(i < iThinkTheBest.length) {
        if (iThinkTheBest(i) < result1) {
          result1 = iThinkTheBest(i)
        }
        else if (iThinkTheBest(i) > result2) {
          result2 = iThinkTheBest(i)
        }
        find(iThinkTheBest,i+1)
      }
      else{
        (result1,result2)
      }
    }
    println(find(list,0))
  }
}
