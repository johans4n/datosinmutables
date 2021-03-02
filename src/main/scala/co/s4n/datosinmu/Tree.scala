package co.s4n.datosinmu

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  /**
   * Esta función cuenta el número de nodos Leaf y Branches en un árbol.
   *
   * @param tree Arbol a recibir
   * @tparam A
   * @return Numero entero con la cantidad de nodos leaf y branches
   */
  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(x, y) => 1 + size(x) + size(y)
  }

  /**
   * Retorna la longitud máxima desde profundidad desde la raı́z a cualquier hoja.
   *
   * @param tree Arbol a explorar
   * @tparam A
   * @return Tamaño de la longitud desde la profundidad
   */
  def depth[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(x, y) => 1 + (if (depth(x) > depth(y)) depth(x) else depth(y))
  }

}
