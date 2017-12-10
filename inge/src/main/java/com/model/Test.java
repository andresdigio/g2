package com.model;

import com.Control.Control;

public class Test {
    public static void main(String[] args){
        Singleton.init();
        System.out.println(Control.getCompanies());
    }
}
