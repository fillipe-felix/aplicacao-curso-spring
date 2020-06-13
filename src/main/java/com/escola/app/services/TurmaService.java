package com.escola.app.services;

import com.escola.app.entities.Turma;
import com.escola.app.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> findAll(){
        return turmaRepository.findAll();
    }

    public Turma findById(Long id){
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        return optionalTurma.get();
    }
}
