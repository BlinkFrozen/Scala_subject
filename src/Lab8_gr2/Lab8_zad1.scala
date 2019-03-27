package Lab8_gr2

object Lab8_zad1 {
  def main(args: Array[String]): Unit = {

    val myPizza = new ThinDough with TomatoSauce with Mozarella with Ham
    println( myPizza.name + myPizza.price )
    val yourPizza = new ThinDough with TomatoSauce with Mozarella with Mushroms
    println( yourPizza.name + yourPizza.price )
    /*
    Ham  Mozarella  Tomato Sauce  on thin dough 14.0
    Mozarella  Mozarella  Tomato Sauce  on thin dough 14.5
    */

  }

abstract class Pizza(){

   def name:String
   def price:Int
}


  trait TomatoSauce extends Pizza{
    //    price = price + 5
    //    name = "Tomato Sauce " + name
    abstract override def name: String = "Tomato sauce " + super.name

    abstract override def price: Int = 3 + super.price
  }

  trait Mozarella extends Pizza{
//    name = "Mozarella " + name
//    price = price + 2
    abstract override def name: String = "Mozarella " + super.name
    abstract override def price: Int =  2 + super.price
  }

  trait Ham extends Pizza{
//    name = "Ham " + name
//    price = price + 3
    abstract override def name: String = "Ham " + super.name
    abstract override def price: Int =  1 + super.price
  }

  trait Mushroms extends Pizza{
//    name = "Mozarella " + name
//    price = price + 4
    abstract override def name: String = "Mozarella " + super.name
    abstract override def price: Int = 5 + super.price
  }

  class ThinDough extends Pizza{

    override def name:String = " on thin dought "
    override def price:Int = 8
  }
}
