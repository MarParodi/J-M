package org.marinap;

public class Categoria {
    private int IDCategoria;
    private String Descripcion;

    // Constructor


    public Categoria(int IDCategoria, String descripcion) {
        this.IDCategoria = IDCategoria;
        Descripcion = descripcion;
    }

    public Categoria(String descripcion) {
        Descripcion = descripcion;
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }
}