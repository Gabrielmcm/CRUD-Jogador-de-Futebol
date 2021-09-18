package com.futdobaum.FutDoBaum.Controller;

import java.util.List;

import com.futdobaum.FutDoBaum.Model.Jogador;
import com.futdobaum.FutDoBaum.Service.JogadorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Jogadores")
public class JogadorController {
    
    @Autowired
    JogadorService servicoJogador;

    @GetMapping
    public List<Jogador> obterTodos(){
       return servicoJogador.obterTodos();
    }

    @GetMapping("/{id}")
    public Jogador obterPorId(@PathVariable String id){
        /**
         * O @PathVariable pega o id que vem na url e transforma em uma variável ID do tipo String
         */
        return servicoJogador.obterPorId(id);
    }

    @PostMapping
    public Jogador adicionar(@RequestBody Jogador Jogador){
        return servicoJogador.adicionar(Jogador);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        servicoJogador.deletar(id);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(
        @PathVariable String id, 
        @RequestBody Jogador Jogador){
            
        return servicoJogador.atualizar(id, Jogador);
    }
}
