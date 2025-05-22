package br.com.challenge.trenspot.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "conteudo")
public class Conteudo extends PanacheEntity {

    @Column(name = "titulo", nullable = false, length = 100)
    public String titulo;

    @Column(name = "descricao", length = 1000)
    private String descricao;

    @Column(name = "trajeto")
    private Integer trajeto;

    @Column(name = "audio", nullable = false, length = 100)
    private String audio;

    @Column(name = "link", length = 255)
    private String link;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "idinvestidor", nullable = false)
    private Long idInvestidor;

    @Column(name = "idplataforma", nullable = false)
    private Long idPlataforma;


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

    public Integer getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(Integer trajeto) {
        this.trajeto = trajeto;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(Long idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }
}