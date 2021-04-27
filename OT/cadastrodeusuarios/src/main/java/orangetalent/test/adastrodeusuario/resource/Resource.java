package orangetalent.test.adastrodeusuario.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import orangetalent.test.cadastrodeusuarios.entity.Endereco;
import orangetalent.test.cadastrodeusuarios.entity.Usuario;
import orangetalent.test.cadastrodeusuarios.repository.EnderecoRepository;
import orangetalent.test.cadastrodeusuarios.repository.UsuarioRepository;

@RestController
public class Resource {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario")
	public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
		Usuario savedUsuario = usuarioRepository.save(usuario);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUsuario.getId()).toUri();

		return ResponseEntity.created(location).build();

}
	@PostMapping("/endereco")
	public ResponseEntity<Object> createEndereco(@RequestBody Endereco endereco) {
		Endereco savedEndereco = enderecoRepository.save(endereco);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEndereco.getId()).toUri();

		return ResponseEntity.created(location).build();

}
}
