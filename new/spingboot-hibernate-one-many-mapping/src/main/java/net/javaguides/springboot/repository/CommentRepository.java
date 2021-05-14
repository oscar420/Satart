package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
