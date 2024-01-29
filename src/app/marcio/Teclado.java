package app.marcio;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

    private final Color CinzaEscuro = new Color(68, 68, 68);
    private final Color Cinzaclaro = new Color(99, 99, 99);
    private final Color verde = new Color(0, 99, 80);

    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 2;
        adicionarBotao("C", CinzaEscuro, c, 0, 0);

        c.gridwidth = 1;

        adicionarBotao("%", CinzaEscuro, c, 2, 0);
        adicionarBotao("/", verde, c, 3, 0);

        adicionarBotao("7", Cinzaclaro, c, 0, 1);
        adicionarBotao("8", Cinzaclaro, c, 1, 1);
        adicionarBotao("9", Cinzaclaro, c, 2, 1);
        adicionarBotao("*", verde, c, 3, 1);

        adicionarBotao("4", Cinzaclaro, c, 0, 2);
        adicionarBotao("5", Cinzaclaro, c, 1, 2);
        adicionarBotao("6", Cinzaclaro, c, 2, 2);
        adicionarBotao("-", verde, c, 3, 2);

        adicionarBotao("1", Cinzaclaro, c, 0, 3);
        adicionarBotao("2", Cinzaclaro, c, 1, 3);
        adicionarBotao("3", Cinzaclaro, c, 2, 3);
        adicionarBotao("+", verde, c, 3, 3);

        c.gridwidth = 2;
        adicionarBotao("0", Cinzaclaro, c, 0, 4);

        c.gridwidth = 1;
        adicionarBotao(",", Cinzaclaro, c, 2, 4);
        adicionarBotao("=", verde, c, 3, 4);

    }
    private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
      botao.addActionListener(this);
        add(botao, c);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() instanceof JButton){

            JButton botao =(JButton) event.getSource();
          LogicaDaCalculadora.getInstancia().processarComando(botao.getText());
        }
    }
}
