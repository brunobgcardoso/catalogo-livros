package br.com.zup.edu.livros.api;

import br.com.zup.edu.livros.model.Autor;
import br.com.zup.edu.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid AutorRequest request, UriComponentsBuilder uriComponentsBuilder){
        Autor autor = request.paraAutor();

        autorRepository.save(autor);

        System.out.println(autor);

        URI location = uriComponentsBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
