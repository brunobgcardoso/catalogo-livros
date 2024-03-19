package br.com.zup.edu.livros.api;

import br.com.zup.edu.livros.model.Autor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    @NotBlank
    @Size(min = 0, max = 120)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Size(min = 0, max = 2500)
    private String descricao;

    @Deprecated
    public AutorRequest() {
    }

    public AutorRequest(String email, String nome, String cpf, String descricao) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.descricao = descricao;
    }

    public Autor paraAutor(){
        return new Autor(
                email,
                nome,
                cpf,
                descricao);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
