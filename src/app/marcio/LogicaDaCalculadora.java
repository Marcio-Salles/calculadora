package app.marcio;

import java.util.ArrayList;
import java.util.List;

public class LogicaDaCalculadora {

    private enum TipoComando {
        ZERAR, NUMERO, DIVISAO, MULTIPLICACAO, SUBTRACAO, SOMA, IGUAL, VIRGULA;
    }

    private static final LogicaDaCalculadora instancia = new LogicaDaCalculadora();

    private final List<Observador> observadores =
            new ArrayList<>();

    private TipoComando ultimaOperacao = null;
    private Boolean substituir = false;
    private String textAtual = "";
    private String textBuffer = "";

    private LogicaDaCalculadora() {

    }

    public static LogicaDaCalculadora getInstancia() {
        return instancia;
    }

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public String getTextAtual() {
        return textAtual.isEmpty() ? "0" : textAtual;
    }

    public void processarComando(String texto) {

        TipoComando tipoComando = detectarTipoComando(texto);

        if (tipoComando == null) {
            return;
            } else if (tipoComando == TipoComando.ZERAR) {
            textAtual = "";
            textBuffer = "";
            substituir = false;
            ultimaOperacao = null;
            } else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
          textAtual= substituir ? texto :textAtual+ texto;
        }
            observadores.forEach(observador -> observador.valorAlterado(getTextAtual()));
        }

         private TipoComando detectarTipoComando(String texto) {
                if (textAtual.isEmpty() && texto == "0") {
                return null;
                 }
                try {
                Integer.parseInt(texto);
                return TipoComando.NUMERO;
                } catch (NumberFormatException e) {
                if ("C".equals(texto)) {
                return TipoComando.ZERAR;
                } else if ("/".equals(texto)) {
                return TipoComando.DIVISAO;

                } else if ("*".equals(texto)) {
                return TipoComando.MULTIPLICACAO;

                } else if ("+".equals(texto)) {
                return TipoComando.SOMA;

                } else if ("-".equals(texto)) {
                return TipoComando.SUBTRACAO;

                } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;

                } else if (",".equals(texto)) {
                return TipoComando.VIRGULA;
            }
            return null;
        }
    }
}

