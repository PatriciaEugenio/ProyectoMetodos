import kotlin.system.measureTimeMillis
/*
Declaracion de la funcion imprimirListas que recibe una lista de tipo string
Asi mismo la lista es utilizada sobre una colección o un elemento iterable.
en donde nos interesa acceder a los elementos de uno en uno para mostrarlo en orden
 */
fun imprimirListas(lista: List<String>) {
    lista.forEach {
        println(it)
    }
}
/*
declaracion de la funcion ordenamientoKotlin que recibe una lista de tipo string
en donde nos retornara una lista ordenada
 */
fun ordenamientoKotlin(lista: List<String>): List<String> {
    return lista.sorted()
}
/*
Declaracion de la funcion tiempoQuicksort que recibe elementos de una lista de tipo string

 */
fun tiempoQuicksort(items: List<String>) {
    var lista: List<String>              //declaracion de variable lista de tipo string
    var tiempo = measureTimeMillis {    //declaracion de variable
        lista = quicksort(items)       //bloque de codigo en donde indica que la lista es igual a los elementos rapidos
    }
/*
Bloque de codigo que muestra que tiempo se demoro en imprimir la lista
en orden
 */
    println("DEMORO $tiempo MILI SEGUNDOS")
    lista.forEach {
        println(it)
    }
}
/*
Declaracion de la variable que ayuda a comparar que los elementos deben
estar ordenados
 */
fun <T : Comparable<T>> quicksort(items: List<T>): List<T> {
    if (items.count() < 1) return items
    val pivot = items[items.count() / 2]                        //Declaración de variable que no cambia
                                                                //en donde indica que pivote es igual al elemento contable
    val equal = items.filter { it == pivot }                    //variable que ayuda a filtrar la variable pivot
    val less = items.filter { it < pivot }                      // variable menor del elemento pivot
    val greater = items.filter { it > pivot }                   //variable mayor del elemento pivot
    return quicksort(less) + equal + quicksort(greater)         // bloque de codigo que ayuda adevolver la coleccion tanto
                                                                //igual en conjunto con el menor y mayor
}
/*
Declaracion de la funcion  tiempoMergeSort que recibe elementos de una lista de tipo string
 */
fun tiempoMergeSort(elementos: List<String>) {
    var lista: MutableList<String>                    //declaracion de variable de una lista de Cadena mutable
    var tiempo = measureTimeMillis {                  //bloque de codigo en donde se declara el tiempo
        lista = Mergesort(elementos.toMutableList())  //bloque de codigo en donde indica que la lista es igual
                                                      // a los elementos de ordenación en la lista mutable
    }
/*
Bloque de codigo que muestra que tiempo se demoro en imprimir la lista
en orden
 */
    println("DEMORO $tiempo MILI SEGUNDOS")
    lista.forEach {
        println(" $it")
    }
}
/*
Declaracion de la funcion en la cual se compara los elementos de la lista mutable
 */
fun <T : Comparable<T>> mergesort(items: MutableList<T>): MutableList<T> {
    if (items.isEmpty()) {
        return items
    }

/*
Declaracion de la funcion merge que recibe como parametro las variables que se encargaran
de unir la lista mutable tanto para la izquierda como para la derecha
 */
    fun merge(left: MutableList<T>, right: MutableList<T>): MutableList<T> {
        var merged: MutableList<T> = arrayListOf<T>()          //variable merged de tipo lista
                                                              // mutable que es igual a una lista de matriz
        while (!left.isEmpty() && !right.isEmpty()) {        //condicion en donde evalua si esta vacia a la izquierda o derecha
            val temp: T                                     //declaracion de la variable temp
            if (left.first() < right.first()) {            //condicion que evalua que va primero si la izquierda o la derecha
                temp = left.removeAt(0)             //variable que remueve a la izquierda
            } else {                                     //condicion que evalua si debe remover a la derecha
                temp = right.removeAt(0)           //variable que remueve a la derecha
            }
            merged.add(temp)
        }
/*
condicion que indica si la variable
esta vacia tanto para izquierda como para derecha
 */
        if (!left.isEmpty()) merged.addAll(left)
        if (!right.isEmpty()) merged.addAll(right)
        return merged
    }
/*
declaracion de las variables
 */
    val pivot = items.count() / 2
    var left = mergesort(items.subList(0, pivot))
    var right = mergesort(items.subList(pivot, items.count() - 1))
    return merge(left, right)
}
/*
Declaracion del metodo burbuja que recibe como parametros listas mutable de numeros de tipo string
 */
fun burbuja(listaNumeros: MutableList<String>): MutableList<String> {
    for (i in (0 until listaNumeros.size - 1)) {
        for (j in (0 until listaNumeros.size - 1)) {
            if (listaNumeros[j] > listaNumeros[j + 1]) {
                var tem = listaNumeros[j]
                listaNumeros[j] = listaNumeros[j + 1]
                listaNumeros[j + 1] = tem
            }
        }
    }
    return listaNumeros
}
/*
Declaracion de la variable tiempo burbuja que recibe como parametros el cual contiene dos variables
una llamada lista que es mutable de tipo string
la otra que es tiempo que se encarga de medir el tiempo en milisegundos
 */
fun tiempoburbuja(elementos: List<String>) {
    var lista: MutableList<String>
    var tiempo = measureTimeMillis {
        lista = burbuja(elementos.toMutableList())
    }
/*
Bloque de codigo que muestra que tiempo se demoro en imprimir la lista
en ordenar
 */
    println("DEMORO $tiempo MILI SEGUNDOS")
    lista.forEach {
        println(" $it")
    }
}
/*
Declaracion del metodo de combinacion de orden que
recibe como parametro una lista mutable de tipo string
 */
fun Mergesort(lista: MutableList<String>): MutableList<String> {
    if (lista.size <= 1) {                                         //condicion que evalua la talla de la lista que sea menor o igual a uno
        return lista                                               //valor que retorna una lista
    }
/*
Declaracion de variables
 */
    val middle = lista.size / 2
    var left = lista.subList(0, middle)
    var right = lista.subList(middle, lista.size)
    return merge(Mergesort(left), Mergesort(right))
}
/*
Declaracion del metodo merge que recibe como parametro dos listas de tipo string
 */
fun merge(left: MutableList<String>, right: MutableList<String>): MutableList<String> {
                                                                                         //declaracion de variables dentro del metodo merge
    var index_Left = 0
    var index_Right = 0
    var newList: MutableList<String> = mutableListOf()
    //condicion while que evalua la cuenta tanto para la izquierda como la derecha
    while (index_Left < left.count() && index_Right < right.count()) {
        if (left[index_Left] <= right[index_Right]) { //condicion que evalua que la variable left sea menor o igua que righ
            newList.add(left[index_Left])   //bloque de codigo que añade una nueva lista
            index_Left++  //contador que va aumentando conforme se añade indices a la izquierda
        } else {  //condicion del modo contrario si se queiere añadir una lista nueva a la derecha
            newList.add(right[index_Right])
            index_Right++
        }
    }
/*
Declaracion del ciclo while que recibe como
parametro el tamaño del indice a la izquierda
 */
    while (index_Left < left.size) {
        newList.add(left[index_Left])
        index_Left++
    }
/*
Declaracion del ciclo while que recibe como
parametro el tamaño del indice a la derecha
 */
    while (index_Right < right.size) {
        newList.add(right[index_Right])
        index_Right++
    }
    return newList         //valor que retorna una lista nueva
}




