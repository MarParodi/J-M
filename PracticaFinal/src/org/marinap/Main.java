package org.marinap;

public class Main {
    public static void main(String[] args) {
        Usuario admin = new Usuario("admin", "1234");
        Login login = new Login(admin);

        if (login.autenticar()) {
            VentanaPrincipal vp = new VentanaPrincipal();
            vp.menu();
        } else {
            System.out.println("Login fallido");
        }
    }
}
