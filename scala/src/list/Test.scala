package list

/**
  * Created by Dad on 5/20/2017.
  */
object Test extends App{

  println(solutions.s01(List(1,2,3)))

  println(solutions.s05(List(1,2,3)))

  println(solutions.s07(List(List(1,2), List(3), List(4, List(5,6)))))

  println(solutions.s08(List(1,1,1)))

  println(solutions.s09(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  println(solutions.s09_1(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
}
