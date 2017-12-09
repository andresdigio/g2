package com.model;

public class Test {
    public static void main(String[] args){
        Singleton.init();
        Control.signUpCompany("company1","pass","pepe","pepe2@pepe","nada","nada","nada","nada","nada","nada","nada","nada","nada", new Location("nada","nada","nada","nada","nada"));
        System.out.println(Control.getCompanies());
    }
}
