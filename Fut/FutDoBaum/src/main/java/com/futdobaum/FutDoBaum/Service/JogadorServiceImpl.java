package com.futdobaum.FutDoBaum.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.futdobaum.FutDoBaum.Model.Jogador;
import com.futdobaum.FutDoBaum.Repository.JogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorServiceImpl implements JogadorService {
    
    @Autowired
    JogadorRepository repositorioJogador;

    @Override
    public List<Jogador> obterTodos() {
        // Pega todos os Jogadores do banco.
        return repositorioJogador.findAll();
    }

    @Override
    public Jogador obterPorId(String idJogador) {
        Optional<Jogador> Jogador = repositorioJogador.findById(idJogador);
       
        if(Jogador.isEmpty()){
            throw new InputMismatchException("Jogador não encontrado com o ID: " + idJogador);
        }

        return Jogador.get();
    }

    @Override
    public Jogador adicionar(Jogador jogador) {
       // Remover o id para garantir que vou adicionar.
       Jogador.setId(null);

       // Metodo save serve para adicionar
       return repositorioJogador.save(jogador);
    }

    @Override
    public void deletar(String idJogador) {
        Optional<Jogador> Jogador = repositorioJogador.findById(idJogador);

        if(Jogador.isEmpty()){
            throw new InputMismatchException("Não é possível deletar o Jogador com o ID: " + idJogador + " - Jogador não encontrado");
        }

        repositorioJogador.deleteById(idJogador);
    }

    @Override
    public Jogador atualizar(String idJogador, Jogador jogador) {
        // Passando o id do Jogador para o proprio Jogador.
        // Eles vem separado na requisição  do tipo PUT 
        Jogador.setId(idJogador);
        
        // Metodo save serve para atualizar
        return repositorioJogador.save(jogador);

        /**
         * O metodo save adiciona caso o id seja null, caso tenha id, ele atualiza.
        */
    }


}