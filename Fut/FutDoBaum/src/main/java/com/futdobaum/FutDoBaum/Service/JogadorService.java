package com.futdobaum.FutDoBaum.Service;

import java.util.List;

import com.futdobaum.FutDoBaum.Model.Jogador;

public interface JogadorService {

    List<Jogador> obterTodos();

    Jogador obterPorId(String idCliente);

    Jogador adicionar(Jogador cliente);
    
    Jogador atualizar(String idCliente, Jogador cliente);

    void deletar(String idCliente);

}
