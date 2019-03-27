package Lab7_gr1

import java.util.Calendar

object Lab7_zad1 {
  def main(args: Array[String]): Unit = {
    val l = new Logger with Quote with TimeStamp
    l.pprint("Hello world")
    println("")
    val ql = new Logger with Quote
    ql.pprint("No date, just quote")
    println("")
    val tl = new Logger with TimeStamp
    tl.pprint("Some time stamped message")
    println("")
    val plain = new Logger
    plain.pprint("Just he text")
    println("")
  }

  class Logger(){
    def pprint(string: String) {print(string)}
  }

  object Logger{}

  trait Quote extends Logger{
    abstract override def pprint(string: String) {print("\""); super.pprint(string); print("\"")}
  }

  trait TimeStamp extends Logger{

    def today = Calendar.getInstance().getTime()

    abstract override def pprint(string: String){print(today);print(" "); super.pprint(string) ; print(" ")}
  }
}
