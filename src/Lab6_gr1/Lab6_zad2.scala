package Lab6_gr1

object Lab6_zad2 {
  def main(args: Array[String]): Unit = {

    val book = BookKeeping()

    book += Expense(20, "lunch")
    book += Expense(200, "jacket")
    book += Income(1002, "subsistence", "10 December")

    println(book)

    book.printMulla()
  }

  class BookKeeping(var amount: Double, var description: String,var date: String) {

    var moneyFlow:List[MoneyFlow] = List[MoneyFlow]()


    override def toString: String = "" + amount + " --- " + "\"" + description + " " + date + "\""

    def printMulla(){
      moneyFlow.foreach(println(_))
    }

    def +=(moneyflow: MoneyFlow):Unit= {
      amount = amount + moneyflow.mulla
      moneyFlow = moneyflow :: moneyFlow
    }

  }
  object BookKeeping {


    def apply(amount: Double = 1000, description: String = "",date:String = "1 January 1970") = new BookKeeping(amount, description,date)

  }


  abstract class MoneyFlow(var amount:Double,var description: String){

    override def toString: String = "" + amount + " --- " + "\"" + description + "\""

    def mulla: Double

  }


  class Expense(amount: Double,description: String) extends MoneyFlow(amount,description){

//    override def toString: String = "" + amount + " --- " + "\"" + description + "\""

    def +(expense: Expense): Expense = Expense(amount + expense.amount, description + ", " + expense.description)

    override def mulla: Double = -amount
  }
  object Expense {

    def apply(amount: Double, description: String) = new Expense(amount, description)

  }


  class Income(amount: Double, description: String,val date:String) extends MoneyFlow(amount,description) {

    override def toString: String = "" + amount + " --- " + "\"" + description + " " + date + "\""

    override def mulla: Double = amount
  }
  object Income {

    def apply(amount: Double, description: String,date:String) = new Income(amount, description,date)

  }
}
