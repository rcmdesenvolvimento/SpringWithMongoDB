package com.miranda.ricardo.springmongo.service;

import java.util.List;

import com.miranda.ricardo.springmongo.model.Funcionario;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate);

    public List<Funcionario> obterFuncionariosPorNome(String nome);

    public Funcionario criar(Funcionario funcionario);

    public void excluir(String id);

}
