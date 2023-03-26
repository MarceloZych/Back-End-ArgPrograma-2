package com.backendargp.login.exp;


import jakarta.validation.constraints.NotBlank;

public class dtoExp {

    @NotBlank
    private String nameE;
    @NotBlank
    private String desc_exp;

    public dtoExp(String nameE, String desc_exp) {
        this.nameE = nameE;
        this.desc_exp = desc_exp;
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
