package co.s4n.datosinmu


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TreeSpec extends AnyFlatSpec with Matchers {

  "1. La función size(Leaf(10))" should " 1 " in {
    Tree.size(Leaf(10)) shouldEqual 1
  }

  "2. La función size(Leaf(10))" should " 1 " in {
    Tree.size(Branch(Leaf(10), Leaf(20))) shouldEqual 3
  }

  "3. La función size(Branch(Branch(Leaf(10),Leaf(20)),Leaf(30))" should " 1 " in {
    Tree.size(Branch(Branch(Leaf(10), Leaf(20)), Leaf(30))) shouldEqual 5
  }

  "4. La función depth(Leaf(10))" should " 1 " in {
    Tree.depth(Leaf(10)) shouldEqual 1
  }

  "5. La función depth(Branch(Branch(Leaf(10),Leaf(20)),Leaf(30)))" should " 3 " in {
    Tree.depth(Branch(Branch(Leaf(10),Leaf(20)),Leaf(30))) shouldEqual 3
  }

  "6. La función depth(Branch(Branch(Leaf(10),Leaf(20)),Branch(Leaf(30),Leaf(40))))" should " 3 " in {
    Tree.depth(Branch(Branch(Leaf(10), Leaf(20)), Branch(Leaf(30), Leaf(40)))) shouldEqual 3
  }

}
