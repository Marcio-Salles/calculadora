package app.marcio;

import javax.swing.*;

public class Calculadora extends JFrame {

    // Criar um metodo construtor
    public Calculadora() {
        setSize(232,322);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Chamar o construtor

    public static void main(String[] args) {

        new Calculadora();
    }
}
