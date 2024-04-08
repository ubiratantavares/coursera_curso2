package br.com.coursera.test;
import br.com.coursera.exception.PilhaVaziaException;
import br.com.coursera.exception.PilhaCheiaException;
import br.com.coursera.model.Pilha;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestPilha {

    private Pilha p;
    @Before
    public void inicializaPilha() {
        p = new Pilha(10);
    }
    @Test
    public void pilhaVazia() {
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void pilhaUmElemento() {
        p.empilha("primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
    }

    @Test
    public void pilhaDoisElementosDesempilhaUmElemento() {
        p.empilha("primeiro");
        p.empilha("segundo");
        assertFalse(p.estaVazia());
        assertEquals(2, p.tamanho());
        assertEquals("segundo", p.topo());
        Object elementoDesempilhado = p.desempilha();
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("primeiro", p.topo());
        assertEquals("segundo", elementoDesempilhado);
    }

    @Test(expected = PilhaVaziaException.class)
    public void removeDaPilhaVazia() {
        p.desempilha();
    }

    @Test
    public void empilhaNaPilhaCheia() {
        for (int i = 0; i < 10; i++) {
            p.empilha("Elemento " + i);
        }
        try {
            p.empilha("boooommm");
            fail();
        } catch (PilhaCheiaException e) {
            System.out.println(e.toString());
        }
    }
}
