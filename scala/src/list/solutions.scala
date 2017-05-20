package list

import scala.collection.immutable.HashMap

object solutions {
  def reverseBetween[T](l : List[T] , m : Int, n : Int) = {
    val a = l.splitAt(m-1)
    val b = a._2.splitAt(n-m+1)
    a._1 ::: b._1.reverse ::: b._2
  }


  def countWord(words : Seq[String]) : Map[String, Int] = {
    words.foldLeft(new HashMap[String, Int])(
      (u, w) => u + (w -> (u.getOrElse(w, 0) + 1))
    )
  }

  def s01[T](a : List[T]) : T = {
    a match {
      case x :: Nil => x
      case x :: tail => s01(tail)
      case Nil => throw new NoSuchElementException
    }
  }

  //reverse
  def s05[T](a : List[T]) : List[T]  = {
    s05Helper(a, List())
  }

  def s05Helper[T](a : List[T], res : List[T]) : List[T] = {
    a match {
      case Nil => res
      case a :: tail => s05Helper(tail , a :: res)
    }
  }

  def s07[T] (a : List[Any]) : List[T] = {
    a.flatMap(x =>
      x match {
        case l : List[Any] => s07(l)
        case a : T => List(a)
      }
    )
  }

  def s08[T] (a : List[T]) : List[T] = {

    a.foldLeft(List[T]())((res , x) =>
        if(res.isEmpty || x != res.last) res :+ x
        else res
    )
  }

  def s08_1[T](a : List[T]) : List[T] = {
    a match {
      case Nil => Nil
      case a :: tail => a :: s08_1(tail.dropWhile( _ == a))
    }
  }

  def s08_1_Helper[T](res : List[T], a : List[T]) : List[T] = {
    a match {
      case Nil => res
      case x :: tail => s08_1_Helper(res :+ x, tail.dropWhile( _ == x))
    }
  }

  def s09[T](a : List[T]) : List[List[T]]= {
    a.foldLeft(List[List[T]](List[T]()))(
      (res, x) =>
        if(res.last.isEmpty || res.last.last == x) res.init :+ (res.last :+x)
        else res :+ List(x)
    )
  }

  def s09_1[T](a : List[T]) :  List[List[T]] = {

    def helper[T](res : List[List[T]], a : List[T]) : List[List[T]] = {
      a match{
        case Nil => res
        case x :: tail => {
          val span = a.span( _== x)
          helper(res :+ span._1, span._2)
        }
      }
    }

    helper(Nil, a)
  }

}
