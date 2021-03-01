package co.s4n.datosinmu

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NaturaluralSpec extends AnyFlatSpec with Matchers {

  "La declaración de el tipo algebráico cero " should " Cero" in {
    val cero = Cero
    cero shouldEqual Cero
  }

  "El valor algebráico de uno " should " Suc(cero) " in {
    val uno = Suc(Cero)
    uno shouldEqual Suc(Cero)
  }


  "El valor algebráico de 2" should " Suc(Suc(cero)) " in {
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


  "EL natural de 0" should " Cero " in {
    val c = Natural.intToNatural(0)
    c shouldEqual Cero
  }

  "El natural de 5" should "  Suc(Suc(Suc(Suc(Suc(Cero))))) " in {
    val f = Natural.intToNatural(5)
    f shouldEqual Suc(Suc(Suc(Suc(Suc(Cero)))))
  }

  "La función addNat(Suc(Suc(Suc(Suc(Cero)))),Suc(Suc(Cero)))" should "  Suc(Suc(Suc(Suc(Suc(Cero))))) " in {

    val f = Natural.addNat(Suc(Suc(Suc(Suc(Cero)))), Suc(Suc(Cero)))
    f shouldEqual Suc(Suc(Suc(Suc(Suc(Suc(Cero))))))
  }

  "La función prodNat(Suc(Suc(Suc(Suc(Cero)))),Suc(Suc(Cero)))" should "  Suc(Suc(Suc(Suc(Suc(Cero))))) " in {

    val f = Natural.prodNat(Suc(Suc(Suc(Suc(Cero)))), Suc(Suc(Cero)))
    f shouldEqual Suc(Suc(Suc(Suc(Suc(Suc(Suc(Suc(Cero))))))))
  }
}
