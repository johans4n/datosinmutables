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

  "9. La función take(3,List(1, 2, 3, 4, 5, 6, 7, 8, 9)) " should "be List(1,2,3,4,5)" in {
    List.take(3, List(1, 2, 3, 4, 5, 6)) shouldEqual List(1, 2, 3)
  }
  "10. La función take(0,List(1,2,3,4)) " should "be List(1,2,3,4)" in {
    List.take(0, List(1, 2, 3, 4)) shouldEqual List(1, 2, 3, 4)
  }

  "11. La función take(5,List(1,2,3,4)) " should "be List(1,2,3,4)" in {
    List.take(5, List(1, 2, 3, 4)) shouldEqual List(1, 2, 3, 4)
  }

  "12. La función drop(5,List(1, 2, 3, 4, 5, 6, 7, 8, 9)) " should "be List(6,7,8,9)" in {
    List.drop(5, List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldEqual List(6, 7, 8, 9)
  }

  "13. La función drop(2,List(1, 2, 3, 4, 5)) " should "be List(3,4,5)" in {
    List.drop(2, List(1, 2, 3, 4, 5)) shouldEqual List(3, 4, 5)
  }

  "14 La función split(5,List(1, 2, 3, 4, 5, 6, 7, 8, 9)) " should "be (List(1,2,3,4,5),List(6,7,8,9))" in {
    List.split(5, List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldEqual(List(1, 2, 3, 4, 5), List(6, 7, 8, 9))
  }

  "15.La función split(0,List(1, 2, 3, 4, 5, 6, 7, 8, 9)) " should "be List(1,2,3,4,5,6,7,8,9),Nil" in {
    List.split(0, List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldEqual(Nil, List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  "16. La función init(List(1, 2, 3, 4, 5)) " should "be List(1,2,3,4)" in {
    List.init(List(1, 2, 3, 4, 5)) shouldEqual List(1, 2, 3, 4)
  }

  "17. La función init(List(1)) " should "be Nil" in {
    List.init(List(1)) shouldEqual Nil
  }

  "18. La función zip(List(1, 2, 3),List(true, false, true)) " should "be List((1,true),(2,false),(3,true))" in {
    List.zip(List(1, 2, 3), List(true, false, true)) shouldEqual List((1, true), (2, false), (3, true))
  }

  "19. La función unzip(List('hola',2),('prueba',3),('zip',4)) " should "be List('hola', 'prueba', 'zip'),List(2, 3, 4))" in {
    List.unzip(List(("hola", 2), ("prueba", 3), ("zip", 4))) shouldEqual(List("hola", "prueba", "zip"), List(2, 3, 4))
  }

  "20. La función unzip(List((1,'a'),(2,'b'),(3,'c')) " should "be List(1, 2, 3),List('a', 'b', 'c'))" in {
    List.unzip(List((1, "a"), (2, "b"), (3, "c"))) shouldEqual(List(1, 2, 3), List("a", "b", "c"))
  }

  "21. La función reverse(List(1, 2, 4, 5)) " should "be List(5, 4, 3, 2, 1))" in {
    List.reverse(List(1, 2, 3, 4, 5)) shouldEqual (List(5, 4, 3, 2, 1))
  }

  "22. La función reverse(List('a', 'b', 'c', 'd')) " should "be List('d', 'c', 'b', 'a')" in {
    List.reverse(List("a", "b", "c", "d")) shouldEqual List("d", "c", "b", "a")
  }

  "23. La función intersperse(3,List(1, 2, 4, 5)) " should "be List(1, 3, 2, 3, 4, 3, 5)" in {
    List.intersperse(3, List(1, 2, 4, 5)) shouldEqual List(1, 3, 2, 3, 4, 3, 5)
  }

  "24. La función intersperse(List('a', 'b', 'c', 'd')) " should "be List('a', 'l', 'b', 'l', 'c', 'l', 'd')" in {
    List.intersperse("l", List("a", "b", "c", "d")) shouldEqual List("a", "l", "b", "l", "c", "l", "d")
  }

  "25. La función concat(List(List(1, 2, 3),List(4, 5, 6))) " should "be List(1, 2, 3, 4, 5, 6)" in {
    List.concat(List(List(1, 2, 3), List(4, 5, 6))) shouldEqual List(1, 2, 3, 4, 5, 6)
  }

  "26. La función concat(List('a', 'b'),List('c', 'd', 'e)) " should "be List('a', 'b', 'c', 'd', 'e')" in {
    List.concat(List(List("a", "b"), List("c", "d", "e"))) shouldEqual List("a", "b", "c", "d", "e")
  }

  "27. La función lenght(List(1, 2, 3 ,4, 5)) " should "be 5" in {
    List.length(List(1, 2, 3, 4, 5)) shouldEqual 5
  }

  "28. La función sum(List(1, 2, 4, 5)) " should "be 15" in {
    List.sum(List(1, 2, 3, 4, 5)) shouldEqual 15
  }

  "29. La función product(List(1, 2, 4, 5)) " should "be 5" in {
    List.product(List(1, 2, 3, 4, 5)) shouldEqual 120
  }

  "30. La función addEnd(1,List(1,3,4,5)" should "be List(1,3,4,5,1)" in {
    List.addEnd(1, List(1, 3, 4, 5)) shouldEqual List(1, 3, 4, 5, 1)
  }

  "31. La función addEnd(Nil,List(1,3,4,5)" should "be List(1,3,4,5)" in {
    List.addEnd(Nil, List(1, 3, 4, 5)) shouldEqual List(1, 3, 4, 5, Nil)
  }

  "32. La función append(List(1, 3),List(1,3,4,5)" should "be List(1,3,1,3,4,5)" in {
    List.append(List(1, 3), List(1, 3, 4, 5)) shouldEqual List(1, 3, 1, 3, 4, 5)
  }

  "33. La función foldRight(List(9L, 6L, 7L), Nil: List[Long])(Const(_,_))" should "Const(9,Const(6,Const(7,Nil)))" in {
    List.foldRight(List(9L, 6L, 7L), Nil: List[Long])(Const(_, _)) shouldEqual Const(9, Const(6, Const(7, Nil)))
  }

  "34. La función length usando foldRight de List(1,2,3,4,5)" should "5" in {
    List.lengthFoldR(List(1, 2, 3, 4, 5)) shouldEqual 5
  }

  "35. La función dropWhile(List(1,2,3,4,5))((x:Int)=>x<3)" should "List(1,2)" in {
    List.dropWhile(List(1, 2, 3, 4, 5))((x: Int) => x < 3) shouldEqual List(3, 4, 5)
  }

  "36. La función dropWhile(List(1,2,3,4,5))((x:Int)=>x>3)" should "List(1,2)" in {
    List.dropWhile(List(1, 2, 3, 4, 5))((x: Int) => x > 3) shouldEqual List(1,2,3)
  }

  "37. La función takeWhile(List(1,2,3,4,5))((x:Int)=>x<3)" should "List(1,2)" in {
    List.takeWhile(List(1, 2, 3, 4, 5))(_ < 3) shouldEqual List(1, 2)
  }

  "38. La función takeWhile(List(1,2,3,4,5))((x:Int)=>x>3)" should "List(4,5)" in {
    List.takeWhile(List(1, 2, 3, 4, 5))(_ > 3) shouldEqual List(4, 5)
  }

  "39. La función filter(List(1,2,3,4,5))((x:Int)=>x>3)" should "List(4,5)" in {
    List.filter(List(1, 2, 3, 4, 5))(_ > 3) shouldEqual List(4, 5)
  }

  "40. La función unzipFoldR(List((1,true),(2,true),(3,false),(4,false))) " should "(List(2,3,4),List(true,true,false,false))" in {
    List.unzipFoldR(List((1,true),(2,true),(3,false),(4,false))) shouldEqual (List(1,2,3,4),List(true,true,false,false))
  }

  "41. La función lengthL(List(1, 2, 3 ,4, 5)) " should "be 5" in {
    List.lengthL(List(1, 2, 3, 4, 5)) shouldEqual 5
  }

  "42. La conjunción lógica de la lista " should " retornar true si todos los datos en la lista son true" in {
    val truelist = List(true, true, true, true)
    List.andL(truelist) shouldEqual true
  }

  "43. La conjunción lógica de la lista " should " retornar true si todos los datos en la lista son true" in {
    val truelist = List(true, false, true, true)
    List.andL(truelist) shouldEqual false
  }

  "44. La función takeWhileL(List(1,2,3,4,5))((x:Int)=>x>3)" should "List(4,5)" in {
    List.takeWhileL(List(1, 2, 3, 4, 5))(_ > 3) shouldEqual List(4, 5)
  }

  "45. La función filterL(List(1,2,3,4,5))((x:Int)=>x>3)" should "List(4,5)" in {
    List.filterL(List(1, 2, 3, 4, 5))(_ > 3) shouldEqual List(4, 5)
  }

  "46. La función unzipL(List('hola',2),('prueba',3),('zip',4)) " should "be List('hola', 'prueba', 'zip'),List(2, 3, 4))" in {
    List.unzipL(List(("hola", 2), ("prueba", 3), ("zip", 4))) shouldEqual(List("hola", "prueba", "zip"), List(2, 3, 4))
  }
}
