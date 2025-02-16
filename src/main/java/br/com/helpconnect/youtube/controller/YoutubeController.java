package br.com.helpconnect.youtube.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.helpconnect.models.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/youtube")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class YoutubeController {
private List<Usuario> listaUsuarios = new ArrayList<>();
	
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
    	return ResponseEntity.ok(listaUsuarios);
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<Usuario> getById(@PathVariable("nome") String nome) {
    	
    	// Pesquisar um usuário pelo id
        Optional<Usuario> usuarioEncontrado = listaUsuarios.stream()
                .filter(usuario -> usuario.getNome().equals(nome))
                .findFirst();

        // Retorna o usuário encontrado ou uma mensagem se não for encontrado
        if (usuarioEncontrado.isPresent()) {
            System.out.println("Usuário encontrado: " + usuarioEncontrado.get());
        } else {
            System.out.println("Usuário não encontrado");
        }
    	
        if(usuarioEncontrado.isPresent()) {
        	return ResponseEntity.ok(usuarioEncontrado.get());
        }
        
        return ResponseEntity.ok(null);
    }
    
    @PostMapping
    public ResponseEntity<List<Usuario>> incluiUsuario(@RequestBody Usuario usuario) {
    	listaUsuarios.add(usuario);
    	return ResponseEntity.ok(listaUsuarios);
    }
    
}
