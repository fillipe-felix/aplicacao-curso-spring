package com.escola.app.repositories;

import com.escola.app.entities.Aluno;
import com.escola.app.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
