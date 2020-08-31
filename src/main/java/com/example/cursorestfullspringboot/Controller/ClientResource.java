package com.example.cursorestfullspringboot.Controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientResource{

    public List<Cliente> clientes;

    @PostConstruct
    public void init(){

        Cliente c1 = new Cliente();
        c1.id = 1;
        c1.nome = "Lucas";
        c1.endereco = "Rua X, 24";
        c1.saldo = 1200.0;

        Cliente c2 = new Cliente();
        c2.id = 2;
        c2.nome = "Juliana";
        c2.endereco = "Rua X, 25";
        c2.saldo = 0.0;

        Cliente c3 = new Cliente();
        c3.id = 3;
        c3.nome = "Elias";
        c3.endereco = "Rua Z, 65";
        c3.saldo = 777.0;

        clientes = Arrays.asList(c1,c2,c3);
    }

    @GetMapping("/cliente")
    public List<Cliente> getCliente(){
        return clientes;
    }

    @GetMapping("/cliente/{id}")
    public Cliente getClienteByCodigo(@PathVariable int id){
        Cliente cliente = null;

        for(Cliente aux : clientes){
            if(aux.id == id){
                cliente = aux;
                break;
            }
        }

        return cliente;
    }
}