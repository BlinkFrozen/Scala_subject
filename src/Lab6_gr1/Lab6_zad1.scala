package Lab6_gr1

object Lab6_zad1 {
  def main(args: Array[String]): Unit = {

    val e = Expense(10, "cinema ticket") + Expense(10, "popcorn")
    println(e)

    val p = Income(10,"money","10 December")
    println(p)

    val book = BookKeeping()
    println(book)

    book -= Expense(20, "lunch")
    book -= Expense(200, "jacket")
    book += Income(1002, "subsistence", "10 December")

    println(book)

    book.printMulla
  }

  class BookKeeping(var amount: Double, var description: String,var date: String) {

    var expenses = List[Expense]()

    var incomes = List[Income]()

    override def toString: String = "" + amount + " --- " + "\"" + description + " " + date + "\""

    def printMulla = {
      println("Expenses:")
      expenses.foreach(println(_))
      println("Incomes:")
      incomes.foreach(println(_))
      println(s"Balance: ${amount}")
    }

    def -=(expense: Expense)= {
      amount = amount - expense.amount
      expenses = expense ::expenses
    }

    def +=(income: Income) = {
      amount = amount + income.amount
      incomes = income :: incomes
    }

    def -(_amount:Double) = amount - _amount

    def +(_amount:Double):Double = amount + _amount
  }

  object BookKeeping {


    def apply(amount: Double = 1000, description: String = "",date:String = "1 January 1970") = new BookKeeping(amount, description,date)

  }


  class Expense(val amount: Double, val description: String) {

    override def toString: String = "" + amount + " --- " + "\"" + description + "\""

    def +(expense: Expense): Expense = Expense(amount + expense.amount, description + ", " + expense.description)

  }
  object Expense {

    def apply(amount: Double, description: String) = new Expense(amount, description)

  }


  class Income(val amount: Double, val description: String,val date:String) {

    override def toString: String = "" + amount + " --- " + "\"" + description + " " + date + "\""

  }

  object Income {

    def apply(amount: Double, description: String,date:String) = new Income(amount, description,date)

  }
}