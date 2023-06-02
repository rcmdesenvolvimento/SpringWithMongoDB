package com.miranda.ricardo.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.miranda.ricardo.springmongo.model.Funcionario;
import com.miranda.ricardo.springmongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/bem-vindo")
    public String bemVindo() {
        return "Seja bem vindo a API";
    }

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @GetMapping("/idade")
    public List<Funcionario> obterFuncionariosPorIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate) {
        return this.funcionarioService.obterFuncionariosPorIdade(de, ate);
    }

    @GetMapping("/por-nome")
    public List<Funcionario> obterFuncionarioPorNome(
            @RequestParam("nome") String nome) {
        return this.funcionarioService.obterFuncionariosPorNome(nome);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return funcionarioService.criar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.funcionarioService.excluir(id);
    }

}
