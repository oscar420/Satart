package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
