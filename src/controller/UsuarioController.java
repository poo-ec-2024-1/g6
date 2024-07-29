package controller;

import com.j256.ormlite.support.ConnectionSource;
import model.Usuario;
import repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(ConnectionSource connectionSource) throws SQLException {
        this.usuarioRepository = new UsuarioRepository(connectionSource);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try {
            Usuario usuario = usuarioRepository.findByEmailAndPassword(email, senha);
            if (usuario != null) {
                usuario.setLogado(true);
                usuarioRepository.update(usuario);
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Email ou senha incorretos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();

        try {
            Usuario usuario = usuarioRepository.read(id);
            if (usuario != null && usuario.isLogado()) {
                usuario.setLogado(false);
                usuarioRepository.update(usuario);
                System.out.println("Logout bem-sucedido!");
            } else {
                System.out.println("Usuário não encontrado ou não está logado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Outros métodos de controle
}
