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
  type AcceptedType <: Food
  def eat(f:AcceptedType):Unit
  override def toString: String = name
}

class Cow(override val name:String = "") extends Animal with Food {
  override type AcceptedType = PlantFood

  override def eat(f: PlantFood): Unit = println(s"Cow $name eats $f")
}

class Woolf(override val name: String = "")  extends Animal{
  override type AcceptedType = Cow

  override def eat(f: Cow): Unit = println(s"Wolf $name eats $f")
}





object Lab10_zad1 extends App {
  val g = new Grass
  val h = new Hay
  val c1 = new Cow("ANiceCow")
  val c2 = new Cow("MilkyCow")
  val w1 = new Woolf("CowEaterBeast")
//  w1.eat(g)// has to fail compilation
  c1.eat( g );
  c2.eat( h );
//  c1.eat( c1 ); // has to fail compilation
  w1.eat( c1 );
  // expected output
  // Cow ANiceCow eats Grass
  // Cow MilkyCow eats Hay
  // Woolf CowEaterBeast eats Cow ANiceCow

}
