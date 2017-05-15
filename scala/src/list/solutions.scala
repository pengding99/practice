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
}
