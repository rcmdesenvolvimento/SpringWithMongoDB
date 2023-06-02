package com.miranda.ricardo.springmongo.service.impl;

import com.miranda.ricardo.springmongo.model.Funcionario;
import com.miranda.ricardo.springmongo.repository.FuncionarioRepository;
import com.miranda.ricardo.springmongo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return funcionarioRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe"));
    }

    @Override
    public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate) {
        return funcionarioRepository.obterFuncionariosPorIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        if (funcionario.getChefe() != null) {
            Funcionario chefe = this.funcionarioRepository.findById(funcionario.getChefe().getCodigo())
                    .orElseThrow(() -> new IllegalArgumentException("Chefe não encontrado"));
            funcionario.setChefe(chefe);
        }
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public void excluir(String id) {
        this.funcionarioRepository.deleteById(id);
    }

}
