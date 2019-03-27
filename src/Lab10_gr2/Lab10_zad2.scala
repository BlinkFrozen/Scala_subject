package Lab10_gr2

object Lab10_zad2 {

  def main(args: Array[String]): Unit = {
    val people = List( ("John", "Doe", 23, "male"), ("Joan", "Doe", 23, "female"),
      ("Steve", "Jenkins", 24, "male"), ("Eva", "Robinson", 25, "female"), ("Ben", "Who", 22, "male"), ("Janet",
      "Reed", 21, "female"), ("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female") )

    println("Males: ")
    println(people.filter(_._4 == "male"))

    println("Famales: ")
    println(people.filter(_._4 == "female"))

    println("Names of people above 23")
    println(people.filter(_._3 >= 23).map(x => x._1))

    println("Is anyone older than 20 years old?")
    println(people.exists(_._3 > 20))

    println("List of first names and ages: ")
    println(people.map(person => (person._1,person._3)))

    println("People split by age: ")
    println(people.groupBy(person => person._3))

    println("People split by the age 23: ")
    println(people.partition(person => person._3 > 23))

    println("The oldest and the youngest: ")
    println(people.maxBy(_._3),people.minBy(_._3))

    val (men,female) = people.partition(person => person._4 == "male")
    println("Are there as many men an woman?")
    println(men.length == female.length)

    println("People above 23 sorted: ")
    println(people.sortBy(_._3).dropWhile(person => person._3 < 23))
  }
}
