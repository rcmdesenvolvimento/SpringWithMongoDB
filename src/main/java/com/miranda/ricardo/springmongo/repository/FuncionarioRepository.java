package com.miranda.ricardo.springmongo.repository;

import com.miranda.ricardo.springmongo.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    @Query("{$and: [{'idade' : { $gte: ?0 } },{'idade':{ $lte: ?1 } } ] }")
    List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate);

    List<Funcionario> findByNome(String nome);

}
