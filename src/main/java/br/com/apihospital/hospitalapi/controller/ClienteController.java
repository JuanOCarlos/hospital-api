package br.com.apihospital.hospitalapi.controller;

import br.com.apihospital.hospitalapi.model.Cliente;
import br.com.apihospital.hospitalapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/cadastro")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/cadastrarcliente")
    public ResponseEntity cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.adicionar(cliente);
        }catch(NullPointerException e) {
            return new ResponseEntity("Algo deu errado!" , HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity("Cliente cadastrado com sucesso!" , HttpStatus.CREATED);
    }

    @GetMapping(value = "/listartodos")
    public ResponseEntity listarTodos() {
        try {
            return new ResponseEntity(clienteService.listarTodos() , HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Não há clientes cadastrados" , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity ListarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity(clienteService.buscarPorId(id) , HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel achar esse id!" , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity atualiarCliente(@PathVariable Integer id , @RequestBody Cliente cliente) {
        try {
            clienteService.atualizar(cliente,id);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel achar esse id!" , HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity("Cliente atualizado com sucesso!" , HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity deletarCliente(@PathVariable Integer id) {
        try {
            clienteService.deletar(id);
        }catch (NoSuchElementException e) {
            return new ResponseEntity("Não foi possivel achar esse id!" , HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity("Cliente deletado com sucesso!" , HttpStatus.OK);
    }
}
