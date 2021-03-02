import co.s4n.datosinmu.List.addEnd
import co.s4n.datosinmu.{Const, List, Nil}

import scala.annotation.tailrec

def unzip[A, B](lst: List[(A, B)]): (List[A], List[B]) = {
  @tailrec
  def unZip(lst: List[(A, B)], lst0: List[A], lst1: List[B]): (List[A], List[B]) = lst match {
    case Nil => (lst0, lst1)
    case Const((h, t), t1) => unZip(t1, addEnd(h, lst0), addEnd(t, lst1))
  }

  unZip(lst, Nil, Nil)
}