 
package com.teamllm.projectOfTeamllm.model;
 
public class Class {
    private int idClass;
    private String code;
    private String name;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class(int idClass, String code, String name) {
        this.idClass = idClass;
        this.code = code;
        this.name = name;
    }

    public Class() {
    }

    public Class(int idClass, String name) {
        this.idClass = idClass;
        this.name = name;
    }
    
}
