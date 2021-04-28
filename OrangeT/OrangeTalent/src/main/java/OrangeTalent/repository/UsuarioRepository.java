package OrangeTalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OrangeTalent.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
