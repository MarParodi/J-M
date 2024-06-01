package org.marinap;

import javax.swing.*;
import java.util.List;

public class ABCProducto extends ABC {
    private ProductoDAO productoDAO = new ProductoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO(); // Necesitas crear esta clase similar a ProductoDAO

    @Override
    public void gestionar() {
        String[] opciones = {"Agregar Producto", "Ver Productos", "Actualizar Producto", "Eliminar Producto"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Productos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (opcion) {
            case 0:
                agregarProducto();
                break;
            case 1:
                verProductos();
                break;
            case 2:
                actualizarProducto();
                break;
            case 3:
                eliminarProducto();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
        int existencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la existencia del producto:"));

        List<Categoria> categorias = categoriaDAO.obtenerCategorias();
        Categoria[] categoriaArray = categorias.toArray(new Categoria[0]);
        Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Seleccione una categoría:",
                "Categoría", JOptionPane.QUESTION_MESSAGE, null, categoriaArray, categoriaArray[0]);
        Producto producto = new Producto(nombre, precio,existencia,categoria);
        productoDAO.agregarProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
    }

    private void verProductos() {
        List<Producto> productos = productoDAO.obtenerProductos();
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append("ID: ").append(p.getIDProducto())
                    .append(", Nombre: ").append(p.getDescripcion())
                    .append(", Precio: ").append(p.getPrecio())
                    .append(", Existencia: ").append(p.getExistencia())
                    .append(", Categoria: ").append(p.getCategoria().getDescripcion())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void actualizarProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto:"));
        int existencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la existencia del producto:"));

        List<Categoria> categorias = categoriaDAO.obtenerCategorias();
        Categoria[] categoriaArray = categorias.toArray(new Categoria[0]);
        Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Seleccione una nueva categoría:",
                "Categoría", JOptionPane.QUESTION_MESSAGE, null, categoriaArray, categoriaArray[0]);

        Producto producto = new Producto(id, nombre, precio,existencia,categoria);
        productoDAO.actualizarProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.");
    }

    private void eliminarProducto() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
        productoDAO.eliminarProducto(id);
        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
    }
}




