package Lab9_gr2

object Lab9_zad1 {

  object Sentences{

    def unapplySeq(text: String): Option[Seq[String]] = {
        if(text.matches("(.*[?!.])"))
          Some(text.split("(?<=[?!.]) "))
        else
          None
    }
  }

  def main(args: Array[String]): Unit = {

    val text  = "Hello Marry! How are you today? I have seen you yesterday in the sample place. What are you doing here?"
    val Sentences(s1,s2,s3,s4, _*) = text
    println(s1)
    println(s2)
    println(s3)
    println(s4)

  }
}
