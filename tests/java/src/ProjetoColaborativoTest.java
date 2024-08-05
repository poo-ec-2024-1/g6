package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ProjetoColaborativoTest {

    @Test
    public void testComentar() {
        ProjetoColaborativo projeto = new ProjetoColaborativo("Projeto Colaborativo", "Desenvolvimento de software", new Date(), new Date());
        
        projeto.comentar("Primeiro comentário do projeto.");
        
        // Verifique se o comentário foi adicionado corretamente
    }

    @Test
    public void testAdicionarArquivo() {
        ProjetoColaborativo projeto = new ProjetoColaborativo("Projeto Colaborativo", "Desenvolvimento de software", new Date(), new Date());
        
        projeto.adicionarArquivo("documento.txt");
        
        // Verifique se o arquivo foi adicionado corretamente
    }
    
    @Test
    public void testComecar() {
        ProjetoColaborativo projeto = new ProjetoColaborativo("Projeto Colaborativo", "Desenvolvimento de software", new Date(), new Date());
        
        projeto.comecar();
        
        // Verifique se o projeto foi iniciado corretamente
    }
}