package co.s4n.datosinmu

import co.s4n.datosinmu.List._

object DatosInmu {
  /**
   * Función literal que recibe una lista y revisa el patrón
   */
  val x = List(4, 5, 6, 7, 8) match {
    case Const(x, Const(5, Const(7, _))) => x
    case Nil => 1
    case Const(x, Const(y, Const(6, (Const(7, _))))) => x + y //este es
    case Const(h, t) => h + sum(t)
    case _ => 777
  }
  val y = tail(List(4, 5, 6, 7))
  val z =  List(3,4,5,5,6)
}