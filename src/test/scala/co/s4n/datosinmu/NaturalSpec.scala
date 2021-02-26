package co.s4n.datosinmu

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NaturaluralSpec extends AnyFlatSpec with Matchers {

  "9. La declaración de el tipo algebráico cero " should " Cero" in {
    val cero = Cero
    cero shouldEqual Cero
  }

  "9. el valor algebráico de uno " should " Suc(cero) " in {
    val uno = Suc(Cero)
    uno shouldEqual Suc(Cero)
  }


  "9. El valor algebráico de 2" should " Suc(Suc(cero)) " in {
    val dos = Suc(Suc(Cero))
    dos shouldEqual Suc(Suc(Cero))
  }

  "El entero del natural Cero" should "  0 " in {
    val cero = Natural.naturalToInt(Cero)
    cero shouldEqual 0
  }

  "El entero del natural Suc(Suc(Suc(Suc(Cero)))) " should " 4 " in {
    val 4 = Natural.naturalToInt(Suc(Suc(Suc(Suc(Cero)))))
    4 shouldEqual 4
  }


  "11. EL natural de 0" should " Cero " in {
    val c = Natural.intToNatural(0)
    c shouldEqual Cero
  }

  "11. El natural de 5" should "  Suc(Suc(Suc(Suc(Suc(Cero))))) " in {
    val f = Natural.intToNatural(5)
    f shouldEqual Suc(Suc(Suc(Suc(Suc(Cero)))))
  }

}
