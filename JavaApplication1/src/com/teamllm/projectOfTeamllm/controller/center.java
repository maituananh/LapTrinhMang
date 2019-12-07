package com.teamllm.projectOfTeamllm.controller;

import java.util.List;
import com.teamllm.projectOfTeamllm.model.Class;
import com.teamllm.projectOfTeamllm.model.Flat;
import com.teamllm.projectOfTeamllm.model.House;
import com.teamllm.projectOfTeamllm.model.Room;
import com.teamllm.projectOfTeamllm.model.Account;
import com.teamllm.projectOfTeamllm.model.Student;

public class center {

    private editDelete editdelete;

    public center() {
        editdelete = new editDelete();
    }

    public List<Account> List() {

        return editdelete.List();
    }

    public List<Account> ListĐK() {

        return editdelete.ListĐK();
    }

    public List<Room> ListRoom() {

        return editdelete.ListRoom();
    }

    public void them(Account sv) {
        editdelete.them(sv);
    }

    public Account thongTinID(int id) {
        return editdelete.thongTinID(id);
    }

    public void sua(Account sv) {
        editdelete.sua(sv);
    }

    public List<Account> timKiemID(int id) {
        return editdelete.timKiemID(id);
    }

    public List<Account> timKiemCode(int code) {
        return editdelete.timKiemCode(code);
    }

    public List<Account> timKiemName(String name) {
        return editdelete.timKiemName(name);
    }

    public boolean login(Account sinhvien) {
        return editdelete.login(sinhvien);
    }

    public boolean submit(Account sinhvien) {
        return editdelete.submitPass(sinhvien);
    }

    public void changePass(Account sinhvien) {
        editdelete.changePass(sinhvien);
    }

    public int idUserSession() {
        return editdelete.sessionUser;
    }

    public boolean authorization() {
        return editdelete.authorization();
    }

    public List<Class> classRoom() {
        return editdelete.classRoom();
    }

    public List<Room> getAllRoom() {
        return editdelete.getAllRoom();
    }

    public List<House> getAllHouse() {
        return editdelete.getAllHouse();
    }

    public List<Flat> getAllFlat() {
        return editdelete.getAllFlat();
    }

    public void updateRoomforStudent(int id, int idRoom) {
        editdelete.updateRoomforStudent(id, idRoom);
    }

    public List<Room> ListRoom(String gender) {

        return editdelete.ListRoom(gender);
    }

    public String getGenderUser(int idUser) {
        return editdelete.getGenderUser(idUser);
    }

    public String suaStatus(int idUser, String status) {
        return editdelete.suaStatus(idUser, status);
    }

    public String suaStatusComplete(int codeS, String status) {
        return editdelete.suaStatusComplete(codeS, status);
    }

    public int suaIDRoom(int code, int room) {
        return editdelete.suaIDRoom(code, room);
    }

    public Student thongTinRoom(int id) {
        return editdelete.thongTinRoom(id);
    }

    public int timRoom(String room, String flat, String house) {
        return editdelete.timRoom(room, flat, house);
    }

    public void suaRoom(int idRoom, int code) {
        editdelete.suaRoom(idRoom, code);
    }

    public List<Account> ListUserOfRoom(int idRoom) {
        return editdelete.ListUserOfRoom(idRoom);
    }

    public String findStatusByIdUser() {
        return editdelete.findStatusByIdUser();
    }

}
