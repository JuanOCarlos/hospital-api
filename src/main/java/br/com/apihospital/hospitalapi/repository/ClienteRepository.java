package br.com.apihospital.hospitalapi.repository;

import br.com.apihospital.hospitalapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
