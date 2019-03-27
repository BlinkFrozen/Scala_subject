//package Lab5_gr1
import scala.math.pow
import scala.math.sqrt

//object Lab5_zad2 {
//  def main(args: Array[String]): Unit = {
//
//    val krk = MapPoint( "Krakow", 50.061389, 19.938333 )
//    println( krk )
//    val nyc = MapPoint( "NYC", 40.7127, -74.0059 )
//    println( nyc )
//    val porto = MapPoint( "Porto", 41.162142, -8.621953 )
//    val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 )
//
//    println( irkutsk )
//    println( porto - irkutsk ) // calculates straight line distance
//    println( krk - irkutsk )
//    println( krk.distanceTo(porto) )
//
//    val r = Route( krk, nyc, porto )
//    println( r ); // observe printing order, hints the container used
//    r.addStop( porto.move( 1, 1 ) )
//    r.addStop( irkutsk )
//    println( r )
//
//  }
//
//  class MapPoint(val name:String = "",val latitude:Double = 0.0,val longitude:Double = 0.0){
//
//    def apply() = new MapPoint()
//
//    def appply(name: String,latitude:Double,longitude:Double) = new MapPoint(name,latitude,longitude)
//
//    def distanceTo(point:MapPoint):Double = sqrt(pow(latitude - point.latitude,2) + pow(longitude - point.longitude,2))
//  }
//
//  }
//}
