package orangetalent.test.cadastrodeusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orangetalent.test.cadastrodeusuarios.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
