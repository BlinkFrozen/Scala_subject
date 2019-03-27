package Lab7_gr3
import scala.math._


object Lab7_zad1 {
  def main(args: Array[String]): Unit = {

    val a1 = Angle(1.5*Pi)
    val a2 = Angle(Pi)
    println(a1)
    println(a2)
    val a3 = a1 + a2
    val a4 = a1 * 0.7

    println(a3)
    println(a4)

    val v1 = SpaceVector3D(1,1,1)
    println(v1)

    println(v1.rot(a3,SpaceVector3D.xaxis).rot(a4,SpaceVector3D.yaxis))
    println(v1.rot(a4,SpaceVector3D.yaxis).rot(a3,SpaceVector3D.xaxis))
  }

  class Angle(val angle:Double = 0.0){



    override def toString(): String = "Kąt wynosi = " + angle/Pi + "*Pi"



    def *(arg:Double) = Angle(arg * angle)

    def +(rhs:Angle) = Angle(angle + rhs.angle)


  }
  object Angle{

    @scala.annotation.tailrec
    def to0_2PI(angle:Double): Double ={
      if(angle < 2*Pi) angle
      else to0_2PI(angle - 2*Pi)
    }

    def apply() = new Angle()

    def apply(angle: Double = 0) = new Angle(to0_2PI(angle))


  }

  class SpaceVector3D(var x:Double = 0,var y:Double = 0,var z:Double = 0){

    override def toString(): String = "(" + x + "," + y + "," + z + ")"

    private def Rotx(angle: Angle): Unit ={
      val temp = y
      y = cos(angle.angle) * y - sin(angle.angle) * z
      z = sin(angle.angle) * temp + cos(angle.angle) * z
    }

    private def Roty(angle: Angle): Unit = {
      val temp = x
      x = cos(angle.angle) * x + sin(angle.angle) * z
      z = -temp * sin(angle.angle) + z * cos(angle.angle)
    }

    private def Rotz(angle: Angle): Unit = {
      val temp = x
      x = cos(angle.angle) * x - sin(angle.angle) * y
      y = temp * sin(angle.angle) + y * cos(angle.angle)
    }

    def rot(angle:Angle,axis:SpaceVector3D.Value): SpaceVector3D ={
      axis match {
        case SpaceVector3D.xaxis => Rotx(angle)
        case SpaceVector3D.yaxis => Roty(angle)
        case SpaceVector3D.zaxis => Rotz(angle)
      }
      this
    }
  }

  object SpaceVector3D extends Enumeration {

    val xaxis,yaxis,zaxis = Value

    def apply() = new SpaceVector3D()

    def apply(x: Double, y: Double, z: Double): SpaceVector3D = new SpaceVector3D(x, y, z)
  }
}
