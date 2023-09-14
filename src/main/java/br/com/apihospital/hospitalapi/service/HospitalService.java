package br.com.apihospital.hospitalapi.service;

import br.com.apihospital.hospitalapi.model.Cliente;
import br.com.apihospital.hospitalapi.model.Hospital;
import br.com.apihospital.hospitalapi.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public void adicionar(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public Hospital buscarPorCnpj(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isEmpty()) {
            return null;
        }
        return optionalHospital.get();
    }

    public void atualizar(Hospital hospital , Integer cnpj) {
        hospitalRepository.existsById(cnpj);
        hospitalRepository.save(hospital);
    }

    public void deletar(Integer cnpj) {
        hospitalRepository.deleteById(cnpj);
    }
}
