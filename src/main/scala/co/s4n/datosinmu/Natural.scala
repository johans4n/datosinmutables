package co.s4n.datosinmu

sealed trait Natural

case object Cero extends Natural

case class Suc(nat: Natural) extends Natural

object Natural {

  /**
   * Convierte el típo de dato Natural a entero
   *
   * @param natural Tipo de dato algebraico de tipo "Natural"
   * @return Entero a partir del natural
   */
  def naturalToInt(natural: Natural): Int = natural
  match {
    case Cero => 0
    case Suc(natural) => 1 + naturalToInt(natural)
  }

  /**
   * Convierte un entero al tipo de dato algebraico Natural
   *
   * @param integer Valor entero
   * @return Valor convertido a natural
   */
  def intToNatural(integer: Int): Natural = integer
  match {
    case 0 => Cero
    case n => Suc(intToNatural(n - 1))
  }

  /**
   * Suma dos listas de tipo Natural
   *
   * @param nat1 Natural 1
   * @param nat2 Natural 2
   * @return Lista sumada
   */
  def addNat(nat1: Natural, nat2: Natural): Natural = (nat1, nat2) match {
    case (Cero, _) => nat2
    case (_, Cero) => nat1
    case (n1, n2) => intToNatural(naturalToInt(n1) + naturalToInt(n2))
  }

  /**
   * Multiplica dos listas de tipo Natural
   *
   * @param nat1 Natural 1
   * @param nat2 Natural 2
   * @return Lista multiplicada
   */
  def prodNat(nat1: Natural, nat2: Natural): Natural = (nat1, nat2) match {
    case (Cero, _) => nat2
    case (_, Cero) => nat1
    case (n1, n2) => intToNatural(naturalToInt(n1) * naturalToInt(n2))
  }

}
