package app.marcio;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculadora extends JFrame {

    // Criar um metodo construtor
    public Calculadora() {

        organizarLayout();

        setSize(232, 322);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    // Organizando layout
    private void organizarLayout() {

        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);
        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);
    }

    // Chamar o construtor

    public static void main(String[] args) {

        new Calculadora();
    }
}
