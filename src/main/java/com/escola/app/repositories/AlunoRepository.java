package com.escola.app.repositories;

import com.escola.app.entities.Aluno;
import com.escola.app.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
