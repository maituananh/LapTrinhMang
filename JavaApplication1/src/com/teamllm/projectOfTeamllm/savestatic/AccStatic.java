/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamllm.projectOfTeamllm.savestatic;

/**
 *
 * @author MaiTuanAnhLapTop
 */
public class AccStatic {

    private static int idStudent;
    private static int code;
    private static String pass;
    private static Boolean role;

    public static Boolean getRole() {
        return role;
    }

    public static void setRole(Boolean role) {
        AccStatic.role = role;
    }

    public static int getIdStudent() {
        return idStudent;
    }

    public static void setIdStudent(int idStudent) {
        AccStatic.idStudent = idStudent;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        AccStatic.code = code;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        AccStatic.pass = pass;
    }
    
    public static boolean changeNumberToBooleanByRole() {
        if (getRole()) {
            return  true;
        } else {
            return false;
        }
    }
}
