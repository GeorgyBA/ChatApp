package com.sda.model.userdto;

import java.io.Serializable;

public class UsernameDto implements Serializable {
   private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
