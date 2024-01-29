package app.marcio;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements Observador{

    private final JLabel label;

    // Metodo construtor

    public Display() {

        LogicaDaCalculadora.getInstancia().adicionarObservador(this);

        label= new JLabel("1234,56");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN,25));
        add(label);

        setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 15));

         setBackground(new Color(46,49,50));
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
