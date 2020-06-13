package com.escola.app.resources;

import com.escola.app.entities.Turma;
import com.escola.app.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "turmas")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        List<Turma> turmaList = turmaService.findAll();
        return ResponseEntity.ok().body(turmaList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id){
        Turma turma = turmaService.findById(id);
        return ResponseEntity.ok().body(turma);
    }
}
