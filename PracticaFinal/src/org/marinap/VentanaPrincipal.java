package org.marinap;

import javax.swing.*;

public class VentanaPrincipal {
    public void menu() {
        String[] opciones = {"Gestionar Productos", "Gestionar Clientes", "Gestionar Proveedores", "Gestionar Ordenes"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (opcion) {
            case 0:
                new ABCProducto().gestionar();
                break;
            case 1:
                new ABCCliente().gestionar();
                break;
            case 2:
                new ABCProveedor().gestionar();
                break;
            case 3:
                new ABCOrden().gestionar();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
