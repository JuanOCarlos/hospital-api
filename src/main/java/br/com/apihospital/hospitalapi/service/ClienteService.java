package br.com.apihospital.hospitalapi.service;

import br.com.apihospital.hospitalapi.model.Cliente;
import br.com.apihospital.hospitalapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void adicionar(Cliente cadastro) {
        clienteRepository.save(cadastro);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> optionalCadastro = clienteRepository.findById(id);
            if (optionalCadastro.isEmpty()) {
                return null;
            }
            return optionalCadastro.get();
    }

    public void atualizar(Cliente cliente, Integer id) {
        clienteRepository.existsById(id);
        clienteRepository.save(cliente);
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
