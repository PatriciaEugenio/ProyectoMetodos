import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/*
declaracion de la clase BusquedaInterfaz de tipo publico que
agrupa funciones y datos para realizar ciertas tareas relacionadas
 */
public class BusquedaInterfaz {
    private JPanel panelPrincipal;//bloque en donde se crea el panel principal
    private JTable Tabla;//bloque de codigo en donde se crea la tabla
    private JTextField valorABuscarCampoTexto;//bloque de codigo que permite al operador del programa
                                             // ingresar una cadena de caracteres por teclado
    /*
    creacion de los botones para buscar que apareceran en la interfaz y
    tiene como objetivo que el usuario pueda interactuar con él
     */
    private JButton ButtonParaBuscarKotlin;
    private JButton ButtonParaBusquedaLineal;
    private JButton ButtonParaBusquedaBinaria;
/*
declaracion de la super clase columnas publica de tipo estatico
 */
    public static Object[] columnas = {"COMPRA", "CANTIDAD", "PISO", "PAGO", "SALDO A DEBER"};
/*
declaracion de la super clase datos publica de tipo estatico el cual contiene
los valores para el acceso de busqueda, si en dado caso se requiere
 */
    public static Object[][] datos = {
            {"MUEBLE", 2, 2,"CREDITO", 1600.50},
            {"TELEFONIA", 2, 1,"CREDITO", 4000.50},
            {"COCINA", 2,1, "CONTADO",18000.90},
            {"ROPA DAMA", 8, 3,"CONTADO", 2000.20},
            {"JUGUETES", 5, 5,"CONTADO", 800.00},
            {"ZAPATERIA", 2, 4,"CONTADO", 1000.50},
            {"ROPA CABALLERO", 4, 3,"CONTADO", 900.00},
            {"JOYERIA", 3, 3,"CREDITO",4000.00},
    };
/*
 declaración de variable pública que puede ser accedida desde fuera de la clase
 llamada BusquedaInterfaz que no recibe ningun parametro
 */
    public BusquedaInterfaz() {
        //boton que se usa para detectar y manejar eventos de acción,
        // los cuales tienen lugar cuando se produce una acción sobre un elemento del programa.
        ButtonParaBuscarKotlin.addActionListener(new ActionListener() {
            @Override
            //es un evento de ActionListener.
            public void actionPerformed(ActionEvent e) {
                buscarKotlin();                           //bloque de codigo que se encarga de buscar
            }
        });
        /*
Boton encargado para la busqueda lineal
         */
        ButtonParaBusquedaLineal.addActionListener(new ActionListener() {
            @Override
            //es un evento de ActionListener.
            public void actionPerformed(ActionEvent e) {
                buscarLinealKotlin();                     //bloque de codigo que se encarga de buscar
            }
        });
        /*
Boton encargado para realizar una busqueda binaria en la interfaz
         */
        ButtonParaBusquedaBinaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaBinaria();
            }
        });
    }
/*
declaracion del método  que no devuelve valores de tipo publico
 */
    public void buscarKotlin() {
        List<String> Compra = new ArrayList<String>();//bloque de codigo que indica que la variable compra
                                                      // es igual a una nueva lista de arreglos
        //ciclo for en donde declara una variable llamada var y su expresion contenedora
        //en donde indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas
        for (int var = 0; var < Tabla.getRowCount(); var++) {

            Compra.add(Tabla.getValueAt(var, 0).toString());//cuerpo del bucle for
        }
        String valorParaBuscar = valorABuscarCampoTexto.getText();     //bloque de codigo que se encarga de buscar el
                                                                       // campo de texto
        MetodosBusquedaKt.busquedaPorKotlin(Compra, valorParaBuscar);
    }
    /*
declaracion del método  buscarLinealKotlin que no devuelve valores y es de tipo publico
     */
    public void buscarLinealKotlin() {
        List<String> Compra = new ArrayList<String>();//bloque de codigo que indica que la variable compra
                                                     // es igual a una nueva lista de arreglos
        /*ciclo for en donde declara una variable llamada var y su expresion contenedora
        en donde indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas*/
        for (int var = 0; var < Tabla.getRowCount(); var++) {
            Compra.add(Tabla.getValueAt(var, 0).toString());
        }
        String valorABuscar = valorABuscarCampoTexto.getText();//bloque de codigo que se encarga
                                                               // de buscar el campo de texto del metodo buscarLinealKotlin
        MetodosBusquedaKt.busquedaLineal(Compra, valorABuscar);

    }
/*
declaracion del método   busquedaBinaria que no devuelve valores y es de tipo publico
 */
    public void busquedaBinaria() {
        List<String> Compra = new ArrayList<String>();//bloque de codigo que indica que la variable compra
                                                     // es igual a una nueva lista de arreglos
/*ciclo for en donde declara una variable llamada var y su expresion contenedora
        en donde indica que la tabla debe ser menor que la variable el cual obtiene el recuento de filas*/
        for (int var = 0; var < Tabla.getRowCount(); var++) {
            Compra.add(Tabla.getValueAt(var, 0).toString());
        }
        String valorABuscar = valorABuscarCampoTexto.getText();//bloque de codigo que se encarga
                                                                 // de buscar el campo de texto del metodo busquedaBinaria
        MetodosBusquedaKt.busquedaBinaria(Compra, valorABuscar);
    }
/*
declaracion del metodo main que es publico de tipo estatico que no retorna valores
que recibe como parmetro un arreglo de tipo string
 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA");
        EventQueue.invokeLater(new Runnable() { //bloque en donde se invoca la cola de eventos
            public void run() {
                //lugar en donde se añaden componentes al panel de contenido
                frame.setContentPane(new BusquedaInterfaz().panelPrincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(800, 512);
                frame.setLocationRelativeTo(null);
            }
        });
    }
/*
Declaracion de la variable createUIComponents el cual se encarga de crear
los componentes del interfaz de usuario
 */
    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        Tabla = new JTable(modelo);
    }
}
