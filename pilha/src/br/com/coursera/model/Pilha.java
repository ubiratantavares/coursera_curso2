package br.com.coursera.model;

import br.com.coursera.exception.PilhaCheiaException;
import br.com.coursera.exception.PilhaVaziaException;

public class Pilha {

    private final Object[] elementos;
    private int quantidade = 0;
    private int maximo;

    public Pilha(int maximo) {
        this.elementos = new Object[maximo];
    }

    public boolean estaVazia() {
        return tamanho() == 0;
    }

    public int tamanho() {
        return this.quantidade;
    }

    public void empilha(Object elemento) {
        if (quantidade == elementos.length) {
            throw new PilhaCheiaException("A pilha encontra-se cheia.");
        }
        this.elementos[this.quantidade] = elemento;
        this.quantidade++;
    }

    public Object topo() {
        return this.elementos[this.quantidade - 1];
    }

    public Object desempilha() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha encontra-se vazia.");
        }
        Object topo = this.topo();
        this.quantidade--;
        return topo;
    }
}
