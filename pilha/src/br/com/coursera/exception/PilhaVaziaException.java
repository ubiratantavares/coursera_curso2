package br.com.coursera.exception;

public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException(String mensagem) {
        super(mensagem);
    }
}
