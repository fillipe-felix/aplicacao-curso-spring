package com.escola.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    private String dataInicio;
    private String datatermino;
    private String horaInicio;
    private String horaTermino;
    private Integer qtdVagas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    //@JsonIgnore
    @OneToMany(mappedBy = "id.turma")
    private Set<Matricula> matriculas = new HashSet<>();

    public Turma() {

    }

    public Turma(Long id, String turno, String dataInicio, String datatermino, String horaInicio,
                 String horaTermino, Integer qtdVagas, Curso curso) {
        this.id = id;
        this.turno = turno;
        this.dataInicio = dataInicio;
        this.datatermino = datatermino;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.qtdVagas = qtdVagas;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(String datatermino) {
        this.datatermino = datatermino;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public Integer getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(Integer qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public Curso getCurso() {
        return curso;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

}
