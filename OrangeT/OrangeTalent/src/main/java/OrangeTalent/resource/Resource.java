package OrangeTalent.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import OrangeTalent.entity.Endereco;
import OrangeTalent.entity.Usuario;
import OrangeTalent.entity.UsuarioEnderecos;
import OrangeTalent.exception.UsuarioNotFoundException;
import OrangeTalent.repository.EnderecoRepository;
import OrangeTalent.repository.UsuarioRepository;

@RestController
public class Resource {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/usuario")
	public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
		Usuario savedUsuario = null;

		try {
			savedUsuario = usuarioRepository.save(usuario);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
				.buildAndExpand(savedUsuario.getCpf()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PostMapping("/endereco")
	public ResponseEntity<Object> createEndereco(@RequestBody Endereco endereco) {
		Endereco savedEndereco = null;

		try {
			savedEndereco = enderecoRepository.save(endereco);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEndereco.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/usuario/{param}")
	public Usuario retrieveUsuario(@PathVariable String param) {
		Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByCpfOrEmail(param, param));

		if (!usuario.isPresent())
			throw new UsuarioNotFoundException("cpf-" + param);

		return usuario.get();
	}
	
	@GetMapping("/usuarioenderecos/{param}")
	public List<UsuarioEnderecos> retrieveUsuarioEnderecos(@PathVariable String param) {
		List<UsuarioEnderecos> usuarioenderecos = usuarioRepository.obterEnderecos(param, param);

		if (usuarioenderecos==null || usuarioenderecos.isEmpty())
			throw new UsuarioNotFoundException("Usuario nao encontrado, tenta novamente");

		return usuarioenderecos;
	}


}
