 
package com.teamllm.projectOfTeamllm.model;
 

public class Gender {
    private int idGender;
    private String name;

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender() {
    }

    public Gender(int idGender, String name) {
        this.idGender = idGender;
        this.name = name;
    }
    
}
