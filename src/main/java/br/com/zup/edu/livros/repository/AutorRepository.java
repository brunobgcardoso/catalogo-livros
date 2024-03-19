package br.com.zup.edu.livros.repository;

import br.com.zup.edu.livros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
