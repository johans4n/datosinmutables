package co.s4n.datosinmu

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ListSpec extends AnyFlatSpec with Matchers {

  "1. list match" should " be 9" in {
    val m = List(4, 5, 6, 7, 8) match {
      case Const(x, Const(5, Const(7, _))) => x
      case Nil => 1
      case Const(x, Const(y, Const(6, Const(7, _)))) => x + y
      case Const(h, t) => h + List.sum(t)
      case _ => 777
    }
    m shouldEqual 9
  }

  "2. La función tail " should " eliminar el primer elemento " in {
    val l1 = List(1, 2, 3, 4, 5)
    val l2 = List(2, 3, 4, 5)
    List.tail(l1) shouldEqual l2
  }

  "3. La función head " should " devolver el primer elmento " in {
    val l1 = List(1, 2, 3, 4, 5)
    List.head(l1).get shouldEqual 1
  }

  "4. La conjunción lógica de la lista " should " retornar true si todos los datos en la lista son true" in {
    val truelist = List(true, true, true, true)
    List.and(truelist) shouldEqual true
  }

  "4. La conjunción lógica de la lista " should " retornar false si alguno de los datos en la lista es false" in {
    val falselist = List(true, true, false, true)
    List.and(falselist) shouldEqual false
  }

  "5. La disyunción lógica " should " false si todos los datos en la lista son falsos" in {
    val falseList = List(false, false, false)
    List.or(falseList) shouldEqual false
  }

  "6. La función max " should " retornar el valor máximo de la lista " in {
    val mx = List(1, 44, 14, 35, 55, 99, 111, 2, 3)
    List.max(mx) shouldEqual 111
  }

  "7. La función min " should " retornar el valor mínimo de la lista " in {
    val mn = List(1, 44, 14, 35, 55, 99, 111, 2, 3)
    List.min(mn) shouldEqual 1
  }

  "8. La función maxMin" should " retornar el valor mínimo y máximo de lista " in {
    val lista = List(3.4, 1.1, 0.001, 2.6, 99.9)
    List.maxMin(lista) shouldEqual(0.001, 99.9)
  }
}
