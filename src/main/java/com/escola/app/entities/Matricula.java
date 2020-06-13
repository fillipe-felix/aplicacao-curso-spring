package com.escola.app.entities;

import com.escola.app.entities.pk.MatriculaPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {

    private String data;
    private Integer formaPagamento;
    private Integer numeroMatricula;


    @EmbeddedId
    private MatriculaPK id = new MatriculaPK();

    public Matricula(){

    }

    public Matricula(Aluno aluno, Turma turma, String data, Integer formaPagamento, Integer numeroMatricula) {
        id.setAluno(aluno);
        id.setTurma(turma);
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.numeroMatricula = numeroMatricula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Aluno getAluno(){
        return id.getAluno();
    }

    public void setAluno(Aluno aluno){
        id.setAluno(aluno);
    }

    @JsonIgnore
    public Turma getTurma(){
        return id.getTurma();
    }

    public void setTurma(Turma turma){
        id.setTurma(turma);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matricula matricula = (Matricula) o;

        return id != null ? id.equals(matricula.id) : matricula.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
