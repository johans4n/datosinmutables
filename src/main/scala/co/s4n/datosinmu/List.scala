package co.s4n.datosinmu

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Const[+A](h: A, t: List[A]) extends List[A]

object List {

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

  def const[A](h: A, t: List[A]): List[A] = Const(h, t)

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
   * Ejercicio 6. Obtener el valor máximo de una lista
   *
   * @param lst Lista de datos de tipo Long
   * @return Valor máximo de la lista
   */
  def max(lst: List[Int]): Int = {
    @tailrec
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
    @tailrec
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
    @tailrec
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
   * @return retorna la suma de la lista
   */
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Const(h, t) => h + sum(t)
  }

  /**
   * Multiplica los valores de una lista de dobles
   *
   * @param ds Lista de dobles
   * @return retorna la multiplicacion de los valores de la lista
   */
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1
    case Const(h, t) => h * product(t)
  }

  /**
   * addEnd: Añade al final de una lista un elemmento dado
   *
   * @param h Cabeza de la lista
   * @param t Cola de la lista
   * @tparam A Tipo de dato
   * @return List con el elemento añadido al final
   */
  def addEnd[A](h: A, t: List[A]): List[A] = t match {
    case Nil => Const(h, Nil)
    case _ => Const(head(t).get, addEnd(h, tail(t)))
  }

  /**
   * Combina dos listas de tipo A
   *
   * @param a primera lista
   * @param b segunda lista
   * @tparam A
   * @return Lista combinada
   */
  @tailrec
  def append[A](a: List[A], b: List[A]): List[A] = (a, b) match {
    case (Nil, Nil) => Nil
    case (l1, Nil) => l1
    case (Nil, l2) => l2
    case (l1, l2) => append(tail(l1), l2)
  }

  /**
   * Corta una lista hasta el número de posición que hayamos enviado
   *
   * @param n    numero de posición
   * @param list lista a recibir
   * @tparam A
   * @return Lista cortada
   */
  @tailrec
  def drop[A](n: Int, list: List[A]): List[A] = (n, list) match {
    case (n, Nil) => Nil
    case (0, l) => l
    case (n, Const(h, t)) => drop(n - 1, t)
  }

  /**
   * take que se encarga de tomar dos parámetros. El primero un valor entero positivo n y el
   * segundo una lista de valores devcualquier tiempo. Y esta función se encarga de tomar los
   * n primeros valores, si existen de la lista.
   *
   * @param n   posición de los n primero valores a tomar
   * @param lst Lista a recibir
   * @tparam A
   * @return Lista con los valores tomados
   */
  def take[A](n: Int, lst: List[A]): List[A] = (n, lst) match {
    case (n, Nil) => Nil
    case (1, Const(h, t)) => Const(h, Nil)
    case (n, Const(h, t)) => Const(h, take(n - 1, t))
  }

  /**
   * Esta función toma una lista y toma los valores iniciales excepto el último.
   *
   * @param lst Lista a recibir
   * @tparam A
   * @return Lista con todos los valores excepto el último
   */
  def init[A](lst: List[A]): List[A] = lst match {
    case Nil => Nil
    case Const(h, Nil) => Nil
    case Const(h, t) => Const(h, init(t))
  }

  /**
   * la función split, recibe dos parámetros n y una lista;
   * divide la primera lista en n elementos y los restantes quedan en la segunda lista.
   *
   * @param n   posición de la lista en la cual se desea dividir la lista
   * @param lst Lista a recibir
   * @tparam A
   * @return Tupla de listas divididas
   */
  def split[A](n: Int, lst: List[A]): (List[A], List[A]) = {
    @tailrec
    def splitAux[A](c: Int, lst2: List[A], acum: List[A]): (List[A], List[A]) = (c, lst2) match {
      case (n, Nil) => (acum, lst2)
      case (0, Const(h, t)) => (acum, lst2)
      case (c, Const(h, t)) => splitAux(c - 1, t, addEnd(h, acum))
    }

    splitAux(n, lst, Nil)
  }

  /**
   * esta función fusiona dos listas de tipos
   * diferentes en una lista de pares del mismo tamaño.
   *
   * @param lst1 Lista 1
   * @param lst2 Lista 2
   * @tparam A
   * @tparam B
   * @return Lista fusionada
   */
  def zip[A, B](lst1: List[A], lst2: List[B]): List[(A, B)] = (lst1, lst2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Const(h, t), Const(h1, t1)) => Const((h, h1), zip(t, t1))
  }

  /**
   * Esta función se encarga de dividir listas fusionadas en pares.
   *
   * @param lst Lista
   * @tparam A
   * @tparam B
   * @return Tupla de listas A y B
   */
  def unzip[A, B](lst: List[(A, B)]): (List[A], List[B]) = {
    @tailrec
    def unZip(lst: List[(A, B)], lst0: List[A], lst1: List[B]): (List[A], List[B]) = lst match {
      case Nil => (lst0, lst1)
      case Const((h, t), t1) => unZip(t1, addEnd(h, lst0), addEnd(t, lst1))
    }

    unZip(lst, Nil, Nil)
  }

  /**
   * Esta función invierte el orden de una lista
   *
   * @param lst Lista a invertir
   * @tparam A
   * @return Lista invertida
   */
  def reverse[A](lst: List[A]): List[A] = {
    @tailrec
    def revers(n: Int, lst: List[A], lst0: List[A]): List[A] = (n, lst) match {
      case (0, Nil) => lst0
      case (n, Const(h, t)) => revers(n - 1, t, Const(h, lst0))
    }

    revers(length(lst), lst, Nil)
  }

  /**
   * Esta se encarga de entremezclar
   * un valor entre los elementos originales de la lista
   *
   * @param elem Valor a entremezclar
   * @param lst Lista a la cual se le desea entremezclar un valor
   * @tparam A
   * @return Lista entremezclada
   */
  def intersperse[A](elem: A, lst: List[A]): List[A] = {
    @tailrec
    def intersper(lst: List[A], lst0: List[A], elem: A): List[A] = (elem, lst) match {
      case (_, Nil) => lst0
      case (Nil, _) => lst
      case (_, Const(h, Nil)) => reverse(Const(h, lst0))
      case (elem, Const(h, t)) => intersper(t, Const(elem, Const(h, lst0)), elem)
    }

    intersper(lst, Nil, elem)
  }


}