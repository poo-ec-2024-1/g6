package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testLogin() {
        Usuario usuario = new Usuario("Maria", "maria@example.com", "senha123");
        
        assertTrue(usuario.login("maria@example.com", "senha123"));
        assertFalse(usuario.login("maria@example.com", "wrongpassword"));
    }

    @Test
    public void testLogout() {
        Usuario usuario = new Usuario("Maria", "maria@example.com", "senha123");
        usuario.login("maria@example.com", "senha123");
        
        usuario.logout();
        
        assertFalse(usuario.isLogado());
    }
}