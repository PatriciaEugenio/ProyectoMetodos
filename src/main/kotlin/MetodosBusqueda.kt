import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
/*
Declararacion de la función busquedaPorKotlin.
En el cual define los tipos de entrada que la función acepta, si corresponde, y declara el tipo
de resultado que muestra. El cuerpo de una
función es el lugar en el que defines las expresiones a las que se llama cuando se invoca la función.
 */
fun busquedaPorKotlin(list: List<String>, valorABuscar: String) {
    var tiempo = measureNanoTime {//Declaracion de variable cuyo valor puede cambiar
        val valorEncontrado = list.find { nombre ->//Declaracion de variable cuyo valor no cambia nunca
            nombre.contains(valorABuscar) //Tiene el propósito de determinar si un elemento existe en una colección
        }

        println(valorEncontrado)//la función println, permite que al final de la salida se ejecute un salto de línea
    }
    println("TIEMPO BUSQUEDA KOTLIN: $tiempo")//valor del tiempo que sera mostrado en pantalla
}
/*
Declararacion de la función busquedaLineal que recibe como argumento una lista de tipo String y
y una variable de tipo string
 */
fun busquedaLineal(list: List<String>, valorABuscar: String): Int? {
    var tiempo = measureNanoTime {                                   //declracion de variable que nos servira para medir el tiempo
        for ((index, valor) in list.withIndex()) {                   //ciclo for que recibe como parámetro el índice (index)
                                                                     // del elemento que deseas retornar de una colección.
            if (valor == valorABuscar) {                             //ciclo if en donde compara el valor si es igual al valor que va a buscar
                println("POSICION ENCONTRADA: $index -> $valor")      //valor que sera mostrado en pantalla si encuentra la posición
                return index                                          //valor que sera retornado
            }
        }
    }
    println("TIEMPO BUSQUEDA LINEAL: $tiempo")   //imprime en pantalla el tiempo que se tarda la funcion busqueda lineal
    return null                                  //valor de retorno si en dado caso no llegase encontrar lo que se esta buscando
}
/*
Declararacion de la función busquedaBinaria que recibe como parametro
una lista de tipo string y una variable de tipo string
 */
fun busquedaBinaria(list: List<String>, key: String): Int? {
    var tiempo = measureNanoTime { //declracion de variable que nos servira para medir el tiempo en la funcion busquedaBinaria
        var rangeStart = 0  //variable de rango inicio
        var rangeEnd = list.count() //rango final que es igual a una lista contable
        while (rangeStart < rangeEnd) { //bloque de código determinado hasta que se cumpla una condición
            val midIndex = rangeStart + (rangeEnd - rangeStart) / 2 //variable cuyo valor no cambia midIndex
            if (list[midIndex] == key) { //bloque de codigo que se ejecuta el código dentro de esa rama
                println("INDEX ENCONTRADO: $midIndex") //bloque que se encarga de imprimir el codigo si en dadollega a encontrar el indice
                return midIndex// bloque que nos ayuda a retornar el indice medio
            } else if (list[midIndex] < key) { //De lo contrario, se ejecuta el código dentro de la rama de else.
                rangeStart = midIndex + 1 //bloque de codigo en donde indica que el rango medio
                                          //debe ser igual al indicemedio mas uno
            } else {                   // de lo contrario a lo que no se cumpla la funcion dentro del else
                                       // anterior se ejecutara lo que viene dentro de este
                rangeEnd = midIndex
            }
        }
    }
/*
bloque de codigo que imprime el tiempo de la busqueda binaria y si en dado caso no se cumpliera
con las condiciones que vienen dentro de la funcion nos retornara un null
 */
    println("TIEMPO BUSQUEDA BINARIA : $tiempo")
    return null
}

