package Lab3_gr1

object Lab3_zad1 {
  def main(args: Array[String]): Unit = {
     println( pi )
    println( pi(pi) )
    println( pi(pi(pi)) )
    printarg(arg="hello")
    printarg()
    println(repN(5, (x: Int) => 2*x , 1 )) // invokes the function N times (here 5) passing the previous result to it, implementation does
    //not need to be recursive of course
    println( max(4)(5) )
    pall( 1,2,3,4,5,4, 3, 3, 4)
  }
  def pi:Double =3.1415

  def pi(x:Double = 1 ): Double = x*3.1415

  def printarg(arg: => String = "-") = println(arg)

  def repN(N:Int,fun :Int => Int, result: Int): Int ={
    if(N == 0)
      result
    else
      repN(N-1,fun,fun(result))
  }

  def max(i: Int)(l:Int) = if(i>l) i else l

//  def pall(i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int, i7: Int, i8: Int) = print(i, i1,i2,i3,i4,i5,i5,i6,i7,i8)

  def pall(i:Int*): Unit = {
    var g = new String
    for (e <- i){
      g += e + " "
    }
    println(g)
  }
}
