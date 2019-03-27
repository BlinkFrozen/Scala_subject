package Lab10_gr2

trait Food{
  val name = "Food"
  override def toString: String = name
}

class PlantFood extends Food{
  override val name: String = "PlantFood"
}

class Hay extends PlantFood{
  override val name: String = "Hay"
}

class Grass extends PlantFood{
  override val name: String = "Grass"
}

abstract class Animal{

  val name = "Animal"

  override def toString: String = name
}

class Cow(override val name:String = "") extends Animal with Food {

  def eat[A <: PlantFood](f: A): Unit = println(s"Cow $name eats $f")
}

class Wolf(override val name: String = "")  extends Animal{


   def eat[A <: Animal with Food](f: A): Unit = println(s"Wolf $name eats $f")
}



object Lab10_zad1 extends App {
  val g = new Grass
  val h = new Hay
  val c1 = new Cow("ANiceCow")
  val c2 = new Cow("MilkyCow")
  val w1 = new Wolf("CowEaterBeast")
//  w1.eat(g)// has to fail compilation
  c1.eat( g )
  c2.eat( h )
//  c1.eat( c1 ) // has to fail compilation
  w1.eat( c1 )
  // expected output
  // Cow ANiceCow eats Grass
  // Cow MilkyCow eats Hay
  // Woolf CowEaterBeast eats Cow ANiceCow

}
