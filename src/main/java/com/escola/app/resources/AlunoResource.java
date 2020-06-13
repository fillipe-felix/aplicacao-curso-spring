package com.escola.app.resources;

import com.escola.app.entities.Aluno;
import com.escola.app.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> cursoList = alunoService.findAll();
        return ResponseEntity.ok().body(cursoList);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<Aluno> findById(@PathVariable String nome) {
        Aluno curso = alunoService.findById(nome);
        return ResponseEntity.ok().body(curso);
    }

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
        obj = alunoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        alunoService.delete(cpf);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<Aluno> update(@PathVariable String cpf, @RequestBody Aluno obj) {
        obj = alunoService.update(cpf, obj);
        return ResponseEntity.ok().body(obj);
    }
}
