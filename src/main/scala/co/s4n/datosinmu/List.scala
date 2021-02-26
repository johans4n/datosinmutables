package co.s4n.datosinmu

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Const[+A](h: A, t: List[A]) extends List[A]

object List extends App {
  /**
   * Ejercicio 1. . ¿Cual es el resultado de la siguiente expresión match?
   * Resultado: 9
   */
  val x = List(4, 5, 6, 7, 8) match {
    case Const(x, Const(5, Const(7, _))) => x
    case Nil => 1
    case Const(x, Const(y, Const(6, (Const(7, _))))) => x + y //este es
    case Const(h, t) => h + sum(t)
    case _ => 777
  }

  /**
   * Ejercicio 2. Implementa la función tail que remueva el primer elemento de
   * un lista.
   *
   * @param as Lista a la cual le sacaremos la cola
   * @tparam A Tipo de objeto dentro de la lista
   * @return Cola de la lista de tipo A
   */
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Const(h, t) => t
  }

  /**
   * Ejercicio 3. Implementa la función head que devuelva el primer elemento de
   * la lista
   *
   * @param as Lista a la cual obtendremos solo la cabeza
   * @tparam A
   * @return Cabeza de la lista de tipo A
   */
  def head[A](as: List[A]): Option[A] = as match {
    case Nil => None
    case Const(h, t) => Some(h)
  }

  /**
   * Ejercicio 4.  Esta funcion recibe un arreglo de valores  Boolean y devuelve true si todos los
   * valores son verdaderos, en caso contrario devuelve false
   *
   * @param lst Lista a evaluar
   * @return Valor resultado de la conjunción
   */
  def and(lst: List[Boolean]): Boolean = {
    @tailrec
    def andA(lst: List[Boolean], acum: Boolean): Boolean = lst match {
      case Nil => acum
      case Const(h, t) => andA(t, h && acum)
    }

    andA(lst, true)
  }


  /**
   * Ejercicio 5. Esta funcion recibe un arreglo de valores ´ Boolean y devuelve false si todos los
   * valores son falsos, en caso contrario devuelve true.
   *
   * @param lst Lista al cual se le aplica la disyunción.
   * @return Valor final de la disyunción
   */
  def or(lst: List[Boolean]): Boolean = {
    @tailrec
    def orA(lst: List[Boolean], acum: Boolean): Boolean = lst match {
      case Nil => acum
      case Const(h, t) => orA(t, h || acum)
    }

    orA(lst, false)
  }

  /**
   * Ejercicio 6.
   *
   * @param lst Lista de datos de tipo Long
   * @return Valor máximo de la lista
   */
  def max(lst: List[Int]): Int = {
    def maxP(lst: List[Int], min: Int): Int = lst match {
      case Nil => min
      case Const(h, t) => maxP(t, if (h > min) h else min)
    }

    maxP(tail(lst), head(lst).get)
  }

  /**
   * Ejercicio 7. Esta funcion recibe un arreglo de valores  Long y devuelve valor mınimo de todos
   * los valores en la lista.
   *
   * @param lst Lista de datos de tipo Long
   * @return Valor mínimo de la lista
   */
  def min(lst: List[Int]): Int = {
    def minP(lst: List[Int], min: Int): Int = lst match {
      case Nil => min
      case Const(h, t) => minP(t, if (h < min) h else min)
    }

    minP(tail(lst), head(lst).get)
  }

  /**
   * Ejercicio 8. Esta funcion recibe un arreglo de valores  Double y devuelve valor (mınimo,maximo)
   * de todos los valores en la lista. Se deben utilizar tuplas para el resultado
   * final
   *
   * @param lst
   * @return
   */
  def maxMin(lst: List[Double]): (Double, Double) = {
    def maxMinP(lst: List[Double], acc: (Double, Double)): (Double, Double) = lst match {
      case Nil => acc
      case Const(h, t) => maxMinP(t, (if (h < acc._1) h else acc._1, if (h > acc._2) h else acc._2))
    }

    maxMinP(tail(lst), (head(lst).get, head(lst).get))
  }

  /**
   * Obtiene el tamaño de la lista
   *
   * @param lst Lista de la cual obtendremos el tamaño
   * @tparam A
   * @return
   */
  def length[A](lst: List[A]): Int = lst match {
    case Nil => 0
    case Const(h, t) => 1 + length(t)
  }

  /**
   * Suma los elementos de una lista de enteros
   *
   * @param ints Lista de enteros
   * @return
   */
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Const(h, t) => h + sum(t)
  }

  /**
   * Multiplica los valores de una lista de dobles
   *
   * @param ds Lista de dobles
   * @return
   */
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1
    case Const(h, t) => h * product(t)
  }

  /**
   * Constructor de listas
   *
   * @param as
   * @tparam A
   * @return
   */
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Const(as.head, apply(as.tail: _*))
  }

}