package Lab6_gr2

object Lab6_zad2 {
  def main(args: Array[String]): Unit = {
  val t1 = STime.apply(12,45,50)
    println(t1)
    val t2 = STime.apply(12,45,49)
    println(t1 < t2)
    println(t1 > t2)
    println(t1.==(t2))
    println(t1 != t2)
    println(t1.moveBy(10)(STime.hour))
  }

  class STime(val hour :Int = 0,val minutes:Int = 0,val seconds:Int = 0) {
    override def toString: String = hour.toString + ":" + minutes.toString + ":" + seconds.toString

    def <(time: STime): Boolean = {
      totaltime() < time.totaltime()
    }

    def >(time: STime): Boolean = {
      totaltime() > time.totaltime()
    }

    def ==(time: STime): Boolean = {
      totaltime() == time.totaltime()
    }

    def !=(time: STime): Boolean = {
      totaltime() != time.totaltime()
    }

    def totaltime(): Int = hour * 3600 + minutes * 60 + seconds


    def moveBy(value: Int)(unit: STime.Value): STime = {
      if (unit == STime.hour)
        STime.apply(this.hour + value, this.minutes, this.seconds)
      else if (unit == STime.minutes)
        STime.apply(this.hour, this.minutes + value, this.seconds)
      else
        STime.apply(this.hour, this.minutes, this.seconds + value)
    }
  }


  object STime extends Enumeration {
    val hour ,minutes , seconds = Value

    def apply() = new STime()
    def apply(hour: Int, minutes: Int, seconds: Int) = new STime(hour, minutes, seconds)

  }
}
