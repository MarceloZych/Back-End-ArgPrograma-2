package com.backendargp.login.exp;

import com.backendargp.login.msj.Msj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exp")
public class ExpController {
    @Autowired
    ExpService expService;

    @GetMapping("/lista")
    public ResponseEntity<List<Exp>> list(){
        List<Exp> list = expService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Exp> getById(@PathVariable("id")int id){
        if(!expService.existsById(id))
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        Exp exp = expService.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!expService.existsById(id)){
            return new ResponseEntity(new Msj("no existe"), HttpStatus.NOT_FOUND);
        }
        expService.delete(id);
        return new ResponseEntity(new Msj("Se elimino corretamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExp dtoexp){
        if(StringUtils.isBlank(dtoexp.getNameE()))
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expService.existsByNameE(dtoexp.getNameE()))
            return new ResponseEntity(new Msj("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    // le borre el "dtoexp.getNameE(), dtoexp.getDescExp()" porque para intellij era redundante
        Exp exp = new Exp(dtoexp.getNameE(), dtoexp.getDesc_exp());
        expService.save(exp);

        return new ResponseEntity(new Msj("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExp dtoexp){
        //Validamos si existe el ID
        if(!expService.existsById(id))
            return new ResponseEntity(new Msj("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(expService.existsByNameE(dtoexp.getNameE()) && expService.getByNameE(dtoexp.getNameE()).get().getId() != id)
            return new ResponseEntity(new Msj("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNameE()))
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Exp experiencia = expService.getOne(id).get();
        experiencia.setNameE(dtoexp.getNameE());
        experiencia.setDesc_exp((dtoexp.getDesc_exp()));

        expService.save(experiencia);
        return new ResponseEntity(new Msj("Experiencia actualizada"), HttpStatus.OK);

    }
}
