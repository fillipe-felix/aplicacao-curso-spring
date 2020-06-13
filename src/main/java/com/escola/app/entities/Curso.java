package com.escola.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String preRequisito;
    private Integer cargaHoraria;
    private Double valor;

    //@JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Turma> turmaList = new ArrayList<>();

    public Curso(){

    }

    public Curso(Long id, String nome, String preRequisito, Integer cargaHoraria, Double valor) {
        this.id = id;
        this.nome = nome;
        this.preRequisito = preRequisito;
        this.cargaHoraria = cargaHoraria;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Turma> getTurmaList() {
        return turmaList;
    }

}
