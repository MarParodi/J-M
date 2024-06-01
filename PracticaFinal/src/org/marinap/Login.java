package org.marinap;

import javax.swing.*;

public class Login {
    private Usuario usuario;

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean autenticar() {
        String username = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String password = JOptionPane.showInputDialog("Ingrese su contraseña:");

        if (usuario.login(username, password)) {
            JOptionPane.showMessageDialog(null, "Login exitoso");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
            return false;
        }
    }
}

