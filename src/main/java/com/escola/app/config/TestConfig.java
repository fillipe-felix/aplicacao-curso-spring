package com.escola.app.config;

import com.escola.app.entities.Aluno;
import com.escola.app.entities.Curso;
import com.escola.app.entities.Matricula;
import com.escola.app.entities.Turma;
import com.escola.app.repositories.AlunoRepository;
import com.escola.app.repositories.CursoRepository;
import com.escola.app.repositories.MatriculaRepository;
import com.escola.app.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("prod")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public void run(String... args) throws Exception {


        Curso curso1 = new Curso(null, "ADS", "Ensino Médio", 200, 1000.0);
        Curso curso2 = new Curso(null, "GTI", "Ensino Médio", 100, 1000.0);

        Turma turma1 = new Turma(null, "Noturno", "12-01-2018", "12-12-2020", "19:00", "22:30", 40, curso1);
        Turma turma2 = new Turma(null, "Diurno", "12-01-2018", "12-12-2020", "7:30", "13:00", 40, curso1);
        Turma turma3 = new Turma(null, "Diurno", "12-01-2018", "12-12-2020", "7:30", "13:00", 40, curso2);

        cursoRepository.saveAll(Arrays.asList(curso1, curso2));

        turmaRepository.saveAll(Arrays.asList(turma1, turma2, turma3));

        Aluno aluno1 = new Aluno("111111111-11", "11111", "Fillipe", "999999", "rua ceara");
        Aluno aluno2 = new Aluno("222222222-22", "22222", "Kaique", "999999", "rua josefina");
        Aluno aluno3 = new Aluno("333333333-33", "33333", "Joao", "999999", "rua andradina");
        Aluno aluno4 = new Aluno("444444444-44", "44444", "Andre", "999999", "rua zeferino");

        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));

        Matricula matricula1 = new Matricula(aluno1, turma1, "12/01/2019", 1, 1212);
        Matricula matricula2 = new Matricula(aluno2, turma1, "12/01/2019", 1, 1313);
        Matricula matricula3 = new Matricula(aluno3, turma2, "12/01/2019", 1, 1414);
        Matricula matricula4 = new Matricula(aluno4, turma2, "12/01/2019", 1, 1515);
        Matricula matricula5 = new Matricula(aluno4, turma1, "12/01/2019", 1, 1515);

        matriculaRepository.saveAll(Arrays.asList(matricula1, matricula2, matricula3, matricula4, matricula5));
    }
}
