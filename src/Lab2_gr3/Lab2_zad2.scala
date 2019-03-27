package Lab2_gr3
import scala.util.Random
import scala.math.pow
import scala.math.sqrt

object Lab2_zad2 {
  def main(args: Array[String]): Unit = {
    val args1 = new Array[Double](20)
    val args2 = new Array[Double](20)
    for (e <-Range(0,20)) {
      args1(e) = Point()
      args2(e) = Point()
    }
    print(args1,args2)
    var energy = TotalEnergy(args1,args2)
    println(energy)

    for(e <- Range(0,10000)){

      val place = Random.nextInt(20)
      val diff = Random.nextDouble()/10
      val shot1 = Random.nextInt(1)
      val shot2 = Random.nextInt(1)
      if(shot1 == 1){
        args1(place) = args1(place) + diff
      }
      else{
        args1(place) = args1(place) - diff
      }
      if(shot2 == 1){
        args2(place) = args2(place) + diff
      }
      else{
        args2(place) = args2(place) - diff
      }

      val maybe = TotalEnergy(args1,args2)

      if(maybe < energy){
        energy = maybe
      }
      else if(shot1 == 1){
        args1(place) = args1(place) - diff
        if(shot2 == 1){
          args2(place) = args2(place) - diff
        }
        else {
          args2(place) = args2(place) + diff
        }
      }
      else {
        args1(place) = args1(place) + diff
        if(shot2 == 1){
          args2(place) = args2(place) - diff
        }
        else {
          args2(place) = args2(place) + diff
        }
      }
    }

    print(args1,args2)

    println(energy)

  }

  def Point (): (Double) = Random.nextDouble()

  def TotalEnergy(point1:Array[Double],point2:Array[Double]): Double = {
    var energy = 0.0

    for(e <- Range(0,20)){
      for(b <- Range(e,20)){
        energy = energy + pow(Distance((point1(e),point2(e)),(point1(b),point2(b))) - 0.5,2)
      }
    }
    energy
  }

  def Distance(point1: (Double, Double),point2:(Double,Double)): Double = {
    sqrt(pow(point1._1 - point2._2,2)+pow(point1._2 - point2._2,2))
  }

  def MovePoint():Double = {
    Random.nextDouble()/10
  }

  def print(args1:Array[Double],args2:Array[Double]): Unit = {
    for(e <- Range(1,20)){
      println((args1(e),args2(e)))
    }
  }
}
