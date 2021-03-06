package Lab9_gr2

    class SPair[+T](val one:T,val two:T){

      def _1[P](value: P) = new SPair(value,two)


      def _2[P](value: P) = new SPair(one,value)
    }

    object spairtest extends App {
      val r = new SPair(1, 3);
      println("" + r.one + " " + r.two)

      class T(val l: String) {
        override def toString() = l
      }

      class T1I(val key: Int) extends T(key.toString) {
      }

      def <<[U](t: SPair[U]) {
        println("" + t.one + " " + t.two)
      }

      val z = new SPair(new T("k1"), new T("k2"))
      <<(z)
      val k = new SPair(new T("k1"), new T1I(67))
      <<(k)
      val kk = new SPair(new T1I(88765), new T1I(67))
      <<(kk)
      val krep1 = k._1(new T1I(1))
      <<(krep1)
      val krep2 = krep1._2(new T("One"))
      <<(krep2)
    }


/*
1 3
k1 k2
k1 67
88765 67
1 67
1 One
*/
