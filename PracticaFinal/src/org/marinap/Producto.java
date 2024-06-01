package org.marinap;

public class Producto {
    private int IDProducto;
    private String Descripcion;
    private double Precio;
    private int Existencia;
     private Categoria categoria;

    public Producto(int IDProducto, String descripcion, double precio, int existencia, Categoria categoria) {
        this.IDProducto = IDProducto;
        Descripcion = descripcion;
        Precio = precio;
        Existencia = existencia;
        this.categoria = categoria;
    }

    public Producto(String descripcion, double precio, int existencia, Categoria categoria) {
        Descripcion = descripcion;
        Precio = precio;
        Existencia = existencia;
        this.categoria = categoria;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int existencia) {
        Existencia = existencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
