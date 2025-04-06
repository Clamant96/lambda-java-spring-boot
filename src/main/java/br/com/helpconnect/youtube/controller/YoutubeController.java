package br.com.helpconnect.youtube.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.helpconnect.models.model.Usuario;
import br.com.helpconnect.repositorys.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/youtube")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class YoutubeController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
    	return ResponseEntity.ok(usuarioRepository.findAll());
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<Usuario> getById(@PathVariable("nome") String nome) {
    	
    	return usuarioRepository.findByNome(nome).map(
    			resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build()
			); 
    }
    
    @PostMapping
    public ResponseEntity<Usuario> incluiUsuario(@RequestBody Usuario usuario) {
    	return ResponseEntity.ok(usuarioRepository.save(usuario));
    }
    
}
