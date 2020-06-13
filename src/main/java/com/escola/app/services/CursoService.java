package com.escola.app.services;

import com.escola.app.entities.Curso;
import com.escola.app.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public Curso findById(Long id){
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.get();
    }

    public Curso insert(Curso curso){
        return cursoRepository.save(curso);
    }

    public void delete(Long id){
        cursoRepository.deleteById(id);
    }

    public Curso update(Long id, Curso obj){
        Curso entity = cursoRepository.getOne(id);
        updateData(entity, obj);
        return cursoRepository.save(entity);
    }

    public void updateData(Curso entity, Curso obj){
        entity.setNome(obj.getNome());
        entity.setCargaHoraria(obj.getCargaHoraria());
        entity.setPreRequisito(obj.getPreRequisito());
        entity.setValor(obj.getValor());
    }
}
