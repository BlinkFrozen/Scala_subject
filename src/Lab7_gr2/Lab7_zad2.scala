object Lab7_zad2  {
  def main(args: Array[String]): Unit = {
    val x = new H(0)
    println( x.human )
    val y = new H(8)
    println( y.human )
    val z = new H(15)
    println( z.human )
    println( ""+z.now() + " " + z.aboutNow() + " " + z.momentAgo())

    val h1 = new TPeriod(100, 120) with HumanComps
    println( h1.human )
  }

  trait HumanComps {
    def tDistance: Int
    def aboutNow(): Boolean = tDistance > 0 && tDistance < 10
    def momentAgo(): Boolean = tDistance >= 10
    def now(): Boolean = tDistance == 0
    def human: String = {

      if (aboutNow())"about now"
      else if (momentAgo()) "a moment ago"
      else "now"
    }
  }

  class TDist(val t: Int) {
    def tDistance: Int = t
  }

  class H( val d: Int ) extends  TDist(d) with HumanComps{}

  class TPeriod ( val start: Int, val stop: Int ) {
    def tDistance: Int =  stop - start
  }
}