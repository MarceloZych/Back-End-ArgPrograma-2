package com.backendargp.login.exp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_exp")
public class Exp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameE;
    private String desc_exp;

    public Exp() {

    }

    public Exp(String nameE, String desc_exp) {
        this.nameE = nameE;
        this.desc_exp = desc_exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDesc_exp() {
        return desc_exp;
    }

    public void setDesc_exp(String desc_exp) {
        this.desc_exp = desc_exp;
    }
}
