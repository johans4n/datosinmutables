# DatosInmutables :pencil:

DatosInmutables es una colección de ejemplos de varias funciones que derivan de un tipo de dato creado. También
contienen la implementación de un tipo de dato creado a partir de la expresión algebráica de los números naturales.

## Requisitos :wrench:

* **sbt version: 1.4.7**
* **Scala version: 2.13.4**

## Implementación :hammer:

```
$ sbt console
$ run
```

## Funciones :bulb:
### Funciones de tipo List :ledger:
* **Tail:** Remueve el primer elemento de una Lista.
* **Head:** Retorna la cabeza de una lista.
* **And:** Realiza la conjunción lógica de una lista de booleanos.
* **Or:** Realiza la disyunción lógica de una lista de booleanos.
* **Max:** Retorna el valor máximo de una lista de enteros.
* **Min:** Retorna el valor mínimo de una lista de enteros.
* **maxMin:** Retorna el valor máximo y mínimo en una tupla de una lista de doubles.
* **Length:** Retorna el valor de la cantidad de elementos en una lista.
* **addEnd:** Añade un elemento al final de una lista.
* **append:** Combina dos listas.
* **drop:** Corta una lista hasta el número de posición que hayamos enviado
* **take:** Se encarga de tomar dos parámetros.
  * El primero un valor entero positivo n.
  * El segundo una lista de valores devcualquier tiempo. 
    
  Esta función se encarga de tomar los n primeros valores, si existen de la lista.
* **Init:** Se encarga de tomar una lista como parametro y retornar los valores iniciales exceptuando el ultimo.
* **Split:** Se encarga de tomar dos parametro y retornar dos listas, la primera con los primero n valores existentes y
  la segunda con los ultimos valores despues de n.
* **Zip:** Se encarga de tomar dos listas como parametros y fusionarlos en una lista de pares del mismo tamaño.
* **Unzip:** Se encarga de tomar una lista de tuplas como parametro y separalas en dos listas distintas.
* **Reverse:** Se encarga de tomar una lista como parametro y retornar una version invertida de la misma.
* **Intersperse:** Se encaga de entremezclar un valor entre los elementos originales de una lista.
* **Concat:** Se encarga de tomar una lista de lista valores de un tipo A y la transforma en una lista de valores tipo

### Funciones de tipo Natural :leaves:
* **naturalToInt:** Convierte el típo de dato Natural a entero.
* **intToNatural:** Convierte un entero al tipo de dato algebraico Natural.
* **addNat:** Suma dos listas de tipo Natural.
* **prodNat:** Multiplica dos listas de tipo Natural.

## Archivos de pruebas
Al interior encontrará dos archivos de pruebas los cuales son
* **ListSpec:** Pruebas para las funciones de tipo List.
* **NaturalSpec:** Pruebas para las funciones de Natural.
