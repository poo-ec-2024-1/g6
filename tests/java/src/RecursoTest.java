package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursoTest {

    @Test
    public void testVisualizar() {
        Recurso recurso = new Recurso("Apostila de Java", "PDF", "Conteúdo da apostila");
        
        // Aqui você pode verificar a saída do método visualizar, se necessário
        recurso.visualizar();
        
        // Certifique-se de que os atributos estão corretos
        assertEquals("Apostila de Java", recurso.getTitulo());
        assertEquals("PDF", recurso.getTipo());
        assertEquals("Conteúdo da apostila", recurso.getConteudo());
    }
}