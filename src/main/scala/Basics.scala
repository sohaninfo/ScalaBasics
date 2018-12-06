import scala.collection.mutable._

object Basics {
  def main(args: Array[String]) = {
    println("Scala Basics!");
    //Step1.doList()
    //Step1.doArray()
    //Step1.doMap()
    //Step1.doTuple()
    //Step1.doOption()
    //Step1.doEnum()
    //Step1.doZipIndex()
    //Step1.doCurrying()
    Step1.imp()
  }
}

object Step1 {

  def doList(): Unit = {
    val  l1 = 1 :: 2 :: Nil
    for( v <- l1) {
      println(v)
    }

    val l2 = "Hamara" :: "Apna" :: "Bajaj" :: Nil

    l2.foreach(a => println(a))
    println("Head:"+l2.head)
    println("Tail:"+l2.tail)

    //val s = l2.sort((s,t) => s.charAt(0).toLower < t.charAt(0).toLower)
    //println("Sorted:"+s)
  }

  object Weekday extends Enumeration {
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  def doArray(): Unit = {
    println("Doing array")
    val a1 = new Array[String](3)
    a1(0) = "New"
    a1(1) = "Delhi"

    println("a1:"+a1(0) + " " + a1(1))
  }

  def doMap(): Unit = {
    val m = new HashMap[String, String]()

    m("Country") = "India"
    m("Capital") = "New Delhi"

    println("Country:"+m.get("Country"))

  }

  def doTuple(): Unit = {
    val t = ("Vivek", 25)
    println("Name:"+t._1)
    println("Age:"+t._2)


  }

  def doOption(): Unit = {
     val m = Map[String, String]()
     m("India") = "New Delhi"
     m("USA") = "Washington"

     val c = Array("India", "China", "USA")

     for( (v) <- c) {
       println("Checking for "+v)
       val k = m.get(v)
       k match {
         case Some(s) => println("Found:"+s)
         case None => println("Not found for "+v)
       }
     }
  }

  def doEnum() : Unit = {
    println("Enum...")
    val e = Weekday.withName("Friday")
    println(e)
  }

  def doZipIndex() : Unit = {
    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    for ((day, count) <- days.zipWithIndex) {
      println(s"$count is $day")
    }

    val t = Array[(Int, String)]((1, "A"))
    for ((v1, v2) <- t) {
      println(s"$v1 is $v2")
    }
  }

  def doCurrying(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFunc = numbers.foldLeft(List[Int]())_

    val squares = numberFunc((xs, x) => xs:+ x*x)
    println(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

    val cubes = numberFunc((xs, x) => xs:+ x*x*x)
    print(cubes.toString())  // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)

    val r1 = numbers.foldLeft(1)((m,n) => m + n)
    println("r1:"+r1.toString)

    val f = (m:Int, n:Int) => m + n
    val r2 = numbers.foldLeft(0)(f)
    println("r2:"+r2.toString)

    val r3 = numberFunc((m,n) => m:+ n)
    println("r3:"+r3.toString)

    val r4 = (0 /: numbers)(_+_)
    println("r4:"+r4)

    val r5 = (numbers :\ 0)(_+_)
    println("r5:"+r5)

  }
  implicit val b = 20
  def f(a:Int)(implicit b:Int): Unit = {
     println("a:"+a)
     println("b:"+b)
  }
  def imp(): Unit = {
     f(1)(2)
    f(8)
  }
}