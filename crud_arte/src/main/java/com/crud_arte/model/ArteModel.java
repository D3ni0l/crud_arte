package com.crud_arte.model;

import com.crud_arte.dto.ArteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// essa classe é um "model" que representa a entidade arte no banco de dados.
// é mapeada com jpa para criar uma tabela chamada "registro_arte".
@Entity // diz que essa classe é uma entidade do banco de dados.
@Table(name = "registro_arte") // define o nome da tabela no banco.
public class ArteModel {

    @Id  // marca o campo como chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o banco vai gerar o id automaticamente (auto-incremento).
    private long id;

    @Column(nullable = false, length = 255) // coluna obrigatória no banco, com limite de 255 caracteres.
    private String titulo;

    @Column(columnDefinition = "TEXT") // coluna para textos longos.
    private String descricao;

    @Column(nullable = false, length = 255) // outra coluna obrigatória, com limite de 255 caracteres.
    private String artista;

    @Column(length = 100) // coluna opcional, com limite de 100 caracteres.
    private String tipo;

    // construtor padrão: obrigatório para o jpa funcionar.
    public ArteModel() {}

    // construtor que converte dados de um artedto para artemodel.
    public ArteModel(ArteDTO art) {
        this.titulo = art.titulo(); // copia o título do dto para o model.
        this.descricao = art.descricao(); // copia a descrição.
        this.artista = art.artista(); // copia o nome do artista.
        this.tipo = art.tipo(); // copia o tipo de arte.
    }

    // métodos getters e setters para acessar e alterar os dados.

    public Long getId() {
        return id; // retorna o id ( o mesmo para os getters abaixo )
    } 

    public void setId(Long id) {
        this.id = id; // define o valor do id ( o mesmo para os setters abaixo )
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
