package com.escola.app.services;

import com.escola.app.entities.Aluno;
import com.escola.app.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(String id) {
        Optional<Aluno> curso = alunoRepository.findById(id);
        return curso.get();
    }

    public Aluno insert(Aluno curso) {
        return alunoRepository.save(curso);
    }

    public void delete(String id) {
        alunoRepository.deleteById(id);
    }

    public Aluno update(String id, Aluno obj) {
        Aluno entity = alunoRepository.getOne(id);
        updateData(entity, obj);
        return alunoRepository.save(entity);
    }

    public void updateData(Aluno entity, Aluno obj) {
        entity.setNome(obj.getNome());
        entity.setCpf(obj.getCpf());
        entity.setRg(obj.getRg());
        entity.setEndereco(obj.getEndereco());
        entity.setFone(obj.getFone());
    }
}
