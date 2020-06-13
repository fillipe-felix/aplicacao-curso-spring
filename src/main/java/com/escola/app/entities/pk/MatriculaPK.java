package com.escola.app.entities.pk;


import com.escola.app.entities.Aluno;
import com.escola.app.entities.Turma;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class MatriculaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public MatriculaPK(){

    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatriculaPK that = (MatriculaPK) o;

        if (turma != null ? !turma.equals(that.turma) : that.turma != null) return false;
        return aluno != null ? aluno.equals(that.aluno) : that.aluno == null;
    }

    @Override
    public int hashCode() {
        int result = turma != null ? turma.hashCode() : 0;
        result = 31 * result + (aluno != null ? aluno.hashCode() : 0);
        return result;
    }
}
