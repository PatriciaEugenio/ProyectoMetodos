import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

    /*
    declaracion de la clase OrdenamientoInterfaz de tipo publico en la cual dentro de ella
    se ordena una interfaz
    */
public class OrdenamientoInterfaz {
    private JPanel panelPrincipal;     //bloque en donde se crea el panel principal
    private JTable tabla;             //bloque de codigo en donde se crea la tabla
    /*
    creacion de los botones de los metodos que apareceran en la interfaz
     */
    private JButton ButtonParaMetodoBurbuja;
    private JButton ButtonParaMetodoQuickSort;
    private JButton ButtonParaMetodoMergeSort;
    private JLabel resultado;

    /*
    declaracion de la super clase columnas publica de tipo estatico
     */
    public static Object[] columnas = {"NOMBRE DE LA COMPRA", "CANTIDAD", "PISO", "PAGO", "SALDO A DEBER"};
    /*
     declaracion de la super clase datos publica de tipo estatico el cual contiene
     los valores para el acceso de busqueda, si en dado caso se requiere
    */
    public static Object[][] datos = {
            {"MUEBLE", 2, 2, "CREDITO", 1600.50},
            {"TELEFONIA", 2, 1, "CREDITO", 4000.50},
            {"COCINA", 2, 1, "CONTADO", 18000.90},
            {"ROPA DAMA", 8, 3, "CONTADO", 2000.20},
            {"JUGUETES", 5, 5, "CONTADO", 800.00},
            {"ZAPATERIA", 2, 4, "CONTADO", 1000.50},
            {"ROPA CABALLERO", 4, 3, "CONTADO", 900.00},
            {"JOYERIA", 3, 3, "CREDITO", 4000.00},
    };

    /*
     declaración de variable OrdenamientoInterfaz pública que puede ser accedida desde fuera de la clase
     y que no recibe ningun parametro
     */
    public OrdenamientoInterfaz() {
        //boton para el metodo QuickSort que se usa para detectar y manejar eventos de acción,
        // los cuales tienen lugar cuando se produce una acción sobre un elemento del programa.
        ButtonParaMetodoQuickSort.addActionListener(new ActionListener() {
            @Override
            //es un evento de ActionListener.
            public void actionPerformed(ActionEvent e) {
                ordenarQuickSort();                           //bloque de codigo que se encarga de ordenar
            }
        });
         /*
         Boton encargado para la busqueda lineal
         */
        ButtonParaMetodoMergeSort.addActionListener(new ActionListener() {
            @Override
            //es un evento de ActionListener.
            public void actionPerformed(ActionEvent e) {
                ordenarMergeSort();                      //bloque de codigo que se encarga de combina u odena
            }
        });
         /*
         Boton encargado para realizar un ordenamiento en el metodo burbuja en la interfaz
         */
        ButtonParaMetodoBurbuja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenamientoBurbuja();
            }
        });
    }
        /*
         declaración de metodo ordenarQuickSort pública que puede ser accedida desde fuera de la clase
         y que no recibe ningun parametro
         */
    public void ordenarQuickSort() {
        //bloque de codigo que indica que la variable compra
        // es igual a una nueva lista de arreglos
        List<String> Compra = new ArrayList<String>();
        //ciclo for en donde declara una variable llamada var y su expresion contenedora en donde
        // indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas
        for (int var = 0; var < tabla.getRowCount(); var++) {
            Compra.add(tabla.getValueAt(var, 0).toString());   //cuerpo del bucle for
        }
        MetodosOrdenamientoKt.tiempoQuicksort(Compra);                //bloque de codigo que se encarga de ordenar el
        // campo de texto
    }
        /*
        declaracion del método  ordenarMergeSort que no devuelve valores y es de tipo publico
        */
    public void ordenarMergeSort() {
        List<String> Compra = new ArrayList<String>();//bloque de codigo que indica que la variable compra
                                                     // es igual a una nueva lista de arreglos
        /*ciclo for en donde declara una variable llamada var y su expresion contenedora
        en donde indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas*/
        for (int var = 0; var < tabla.getRowCount(); var++) {
            Compra.add(tabla.getValueAt(var, 0).toString());
        }
        MetodosOrdenamientoKt.tiempoMergeSort(Compra); //bloque de codigo que se encarga
        // de ordenar el campo de texto del metodo ordenarMergeSort
    }
        /*
        declaracion del método   ordenamientoBurbuja que no devuelve valores y es de tipo publico
         */
    public void ordenamientoBurbuja() {
        List<String> Compra = new ArrayList<String>(); //bloque de codigo que indica que la variable compra
        // es igual a una nueva lista de arreglos
/*ciclo for en donde declara una variable llamada var y su expresion contenedora
        en donde indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas*/
        for (int var = 0; var < tabla.getRowCount(); var++) {
            Compra.add(tabla.getValueAt(var, 0).toString());
        }
        MetodosOrdenamientoKt.tiempoburbuja(Compra);//bloque de codigo que se encarga
        // de ordenar el campo de texto del metodo ordenamientoBurbuja
    }
        /*
        declaracion del metodo main que es publico de tipo estatico que no retorna valores
        que recibe como parmetro un arreglo de tipo string
         */
    public static void main(String[] args) {
        /*
        bloque de codigo  para generar ventanas
        sobre las cuales añade distintos objetos con los que podrá interactuar el usuario.
         */
        JFrame frame = new JFrame("VENTANA");
        frame.setContentPane(new OrdenamientoInterfaz().panelPrincipal);//establece el panel de contenido
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//establece la operación de cierre predeterminada
        frame.pack(); //genera el paquete
        frame.setVisible(true); //establece la visibilidad
        frame.setSize(512, 512); //establece el tamaño
        frame.setLocationRelativeTo(null); //establece la ubicación relativa
    }
        /*
        Declaracion de la variable createUIComponents el cual se encarga de crear
        los componentes del interfaz de usuario
         */
    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modelo);
    }
}
