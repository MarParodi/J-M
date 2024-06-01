package org.marinap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO Producto (Descripcion, Precio, Existencia, IDCategoria) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getExistencia());
            stmt.setInt(4,producto.getCategoria().getIDCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.IDProducto, p.Descripcion, p.Precio, c.Descripcion AS Categoria,  p.Existencia FROM Producto p JOIN Categoria c ON p.IDCategoria = c.IDCategoria";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getString("Descripcion")
                );
                Producto producto = new Producto(
                        rs.getInt("IDProducto"),
                        rs.getString("Descripcion"),
                        rs.getDouble("Precio"),
                        rs.getInt("Existencia"),
                        categoria
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE Producto SET Descripcion = ?, Precio = ?, Existencia = ?, IDCategoria = ? WHERE idProducto = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3,producto.getExistencia());
            stmt.setInt(4, producto.getCategoria().getIDCategoria());
            stmt.setInt(5, producto.getIDProducto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM Producto WHERE IDProducto = ?";

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
