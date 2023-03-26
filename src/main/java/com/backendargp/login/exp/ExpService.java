package com.backendargp.login.exp;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpService {

    @Autowired
    ExpRepository expRepository;

    public List<Exp> list(){
        return expRepository.findAll();
    }

    public Optional<Exp> getOne(int id){
        return expRepository.findById(id);
    }

    public Optional<Exp> getByNameE(String nameE){
        return expRepository.findByNameE(nameE);
    }

    public void save (Exp exp){
        expRepository.save(exp);
    }

    public void delete(int id){
        expRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return expRepository.existsById(id);
    }

    public boolean existsByNameE(String nameE){
        return expRepository.existsByNameE(nameE);
    }

}
