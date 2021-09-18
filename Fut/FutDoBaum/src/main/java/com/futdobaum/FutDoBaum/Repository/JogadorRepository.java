package com.futdobaum.FutDoBaum.Repository;

import com.futdobaum.FutDoBaum.Model.Jogador;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends MongoRepository<Jogador, String> {
    
}
