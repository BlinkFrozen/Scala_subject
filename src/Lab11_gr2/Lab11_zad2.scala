package Lab11_gr2

import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.Random

object Lab11_zad2 extends App {

  def psearch(vec: Vector[Char], c: Char): Future[Boolean] = {

    val vec_split = vec.grouped(vec.length / 10)

    val f = vec_split.map(x => Future{
      x.contains(c)
    })

    Future.sequence(f) map {
      _.contains(true)
    }

  }

  val x = Random.alphanumeric
  val rstr = (x take 100).toVector
  println(rstr)
  val found = psearch( rstr, 'x')
  found onSuccess {
    case f => println("found " + f )
  }

  Await.ready( found , Duration(10, SECONDS))

}