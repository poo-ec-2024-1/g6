package com.maria_dutra.estudocolaborativo.services;

import com.maria_dutra.estudocolaborativo.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();
    private Long nextId = 1L;

    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        return usuarioOptional.orElse(null);
    }

    public Usuario addUsuario(Usuario usuario) {
        usuario.setId(nextId++);
        usuarios.add(usuario);
        return usuario;
    }

    public void deleteUsuario(Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}
