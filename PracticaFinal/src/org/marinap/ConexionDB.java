package org.marinap;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/ZhoeParodi";
    private static final String username = "root";
    private static final String password = "12345MvP2205";


    public static Connection getConnection() {
        Connection con = null;
        try {
            // Carga el driver de MySQL en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Crea la conexión con la base de datos
            con = DriverManager.getConnection(url,username,password);
            JOptionPane.showMessageDialog(null, "La conexión se llevó a cabo con éxito :P");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + e.toString());
        } catch (ClassNotFoundException cE) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + cE.toString());
        }
        return con;
    }
}

