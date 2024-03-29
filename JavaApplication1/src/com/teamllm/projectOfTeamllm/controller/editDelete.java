package com.teamllm.projectOfTeamllm.controller;

import com.teamllm.projectOfTeamllm.connect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teamllm.projectOfTeamllm.model.Class;
import com.teamllm.projectOfTeamllm.model.Flat;
import com.teamllm.projectOfTeamllm.model.House;
import com.teamllm.projectOfTeamllm.model.Room;
import com.teamllm.projectOfTeamllm.model.Account;
import com.teamllm.projectOfTeamllm.model.Student;
import com.teamllm.projectOfTeamllm.savestatic.AccStatic;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editDelete {

    public Connection connectSQL = connect.getJDBCConnection();

    public List<Account> List() {
        List<Account> stringList1 = new ArrayList<>();
        try {
            String sql1 = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,room.nameRoom"
                    + " from account \n"
                    + " JOIN room ON account.idRoom=room.idRoom where account.status='yes'\n";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("idStudent");
                int code = rs.getInt("code");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, nameRoom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    public List<Account> ListĐK() {
        List<Account> stringList1 = new ArrayList<>();
        try {
            String sql1 = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,account.history,room.nameRoom"
                    + " from account \n"
                    + " JOIN room ON account.idRoom=room.idRoom where account.status='waiting'\n";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("idStudent");
                int code = rs.getInt("code");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String history = rs.getString("history");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, history, nameRoom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    public Account thongTinID(int id) {
        try {
            Account acc = new Account();
            String sql1 = "Select * from account where idStudent = ?";
            PreparedStatement pre = connectSQL.prepareStatement(sql1);
            pre.setInt(1, AccStatic.getIdStudent());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                acc.setFullname(rs.getString("name"));
                acc.setAge(rs.getInt("age"));
                acc.setGender(rs.getString("gender"));
                acc.setClassName(rs.getString("className"));
            }
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void them(Account stringList1) {
        String sql = "INSERT INTO account (code,password, name, age, gender, className, status)"
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            //Interger.parseInt(): ép kiểu dự liệu từ String sang int khi từ jsp sang jav
            pre.setInt(1, stringList1.getCode());
            pre.setString(2, stringList1.getPass());
            pre.setString(3, stringList1.getFullname());
            pre.setInt(4, stringList1.getAge());
            pre.setString(5, stringList1.getGender());
            pre.setString(6, stringList1.getClassName());
            pre.setString(7, "no"); // mặc dinh khi them moi status  = no
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void sua(Account stringList1) {
        String sql = "UPDATE account SET name=?,age=?,gender=?,className=? WHERE idStudent= ?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setString(1, stringList1.getFullname());
            pre.setInt(2, stringList1.getAge());
            pre.setString(3, stringList1.getGender());
            pre.setString(4, stringList1.getClassName());
            pre.setInt(5, AccStatic.getIdStudent());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int login(int code, String pass) {
        String sql = "select * from account WHERE code=? and password=?";
        Account student = new Account();
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("idStudent"));
                student.setCode(rs.getInt("code"));
                student.setRole(rs.getInt("role"));
                student.setPass(rs.getString("password"));
            }
            if (student.getId() != 0) {
                return student.getId();
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean authorization(int id) {
        String sql = "select * from account WHERE idStudent = ?";
        Account student = new Account();
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            int role = 0;
            while (rs.next()) {
                role = rs.getInt("role");
            }
            if (role == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean submitPass(Account ac) {
        List<Account> stringList = new ArrayList<>();
        String sql = "select * from account WHERE idStudent=? and password=?";
        Account student = new Account();
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            preparedStatement.setInt(1, AccStatic.getIdStudent());
            preparedStatement.setString(2, ac.getPass().trim());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("idStudent"));
                student.setPass(rs.getString("password"));
                stringList.add(student);
            }
            if (stringList.size() == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void changePass(Account stringList1) {
        String sql = "UPDATE  account SET password=? WHERE idStudent= ?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setString(1, stringList1.getPass());
            pre.setInt(2, AccStatic.getIdStudent());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> timKiemID(int id) {
        List<Account> stringList1 = new ArrayList<>();
        String sql = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,account.history,room.nameRoom"
                + " from account \n"
                + " JOIN room ON account.idRoom=room.idRoom where account.idStudent=?";
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            Account sv = new Account(id);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int code = rs.getInt("code");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String history = rs.getString("history");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, history, nameRoom));
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    public List<Account> timKiemName(String name) {
        List<Account> stringList1 = new ArrayList<>();
        String sql = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,account.history,room.nameRoom"
                + " from account \n"
                + " JOIN room ON account.idRoom=room.idRoom where account.name like ?";
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            Account sv = new Account(name);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idStudent");
                int code = rs.getInt("code");
                String pass = rs.getString("password");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String history = rs.getString("history");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, history, nameRoom));
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    public List<Account> timKiemCode(int code) {
        List<Account> stringList1 = new ArrayList<>();
        String sql = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,account.history,room.nameRoom"
                + " from account \n"
                + " JOIN room ON account.idRoom=room.idRoom where account.code=?";
        try {
            PreparedStatement preparedStatement = connectSQL.prepareStatement(sql);
            Account sv = new Account(code);
            preparedStatement.setInt(1, code);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idStudent");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String history = rs.getString("history");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, history, nameRoom));
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    public Student thongTinRoom(int id) {
        try {
            Student sv = new Student();
            String sql1 = "Select * from account \n"
                    + " JOIN room ON account.idRoom=room.idRoom \n"
                    + "JOIN flat ON room.idFlat=flat.idFlat  \n"
                    + "JOIN house ON  flat.idHouse=house.idhouse where code = ?";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sv.setIdRoom(rs.getInt("idRoom"));
            }
            return sv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String suaStatus(int code, String status) {
        String sql = "UPDATE  ltm.account SET status=? WHERE code = ?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setString(1, status);
            pre.setInt(2, code);
            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public String suaStatusComplete(int code, String status) {
        String sql = "UPDATE  ltm.account SET status=? WHERE code = ?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setString(1, status);
            pre.setInt(2, code);
            pre.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public int suaIDRoom(int code, int room) {
        String sql = "UPDATE  ltm.account SET idRoom=? WHERE code = ?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setInt(1, room);
            pre.setInt(2, code);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public void xoa(int id) {
        String sql = "DELETE FROM users WHERE idUser=?";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Class> classRoom() {
        List<Class> listST = new ArrayList<>();
        try {
            String sql1 = "Select * from class";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("idClass");
                String code = rs.getString("codeClass");
                String name = rs.getString("nameClass");
                listST.add(new Class(id, code, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listST;
    }

    public String getGenderUser(int idUser) {
        String sql = "select gender from account where code=?";
        PreparedStatement pre;
        String gender = null;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setInt(1, idUser);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                gender = rs.getString("gender");
            }
        } catch (SQLException ex) {
            Logger.getLogger(editDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gender;
    }

    public String getCodeUser(int idUser) {
        String sql = "select status from account where code=?";
        PreparedStatement pre;
        String status = null;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setInt(1, idUser);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(editDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public List<House> getAllHouse() {
        List<House> listST = new ArrayList<>();
        try {
            connectSQL = connect.getJDBCConnection();
            String sql1 = "Select * from house";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                House h = new House();
                h.setIdHouse(rs.getInt("idHouse"));
                h.setNameHouse(rs.getString("nameHouse"));
                listST.add(h);
            }
        } catch (SQLException e) {
        }
        return listST;
    }

    public List<Room> getAllRoom(String gender) {
        List<Room> listST = new ArrayList<>();
        try {
            connectSQL = connect.getJDBCConnection();
            String sql1 = "Select * from ltm.room where gender='" + gender + "'";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                Room h = new Room();
                h.setIdRoom(rs.getInt("idRoom"));
                h.setNameRoom(rs.getString("nameRoom"));
                listST.add(h);
            }
        } catch (SQLException e) {
        }
        return listST;
    }

    public List<Room> getAllRoom() {
        List<Room> listST = new ArrayList<>();
        try {
            connectSQL = connect.getJDBCConnection();
            String sql1 = "Select * from ltm.room  ";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            //pre.setString(1, gender); //loi cho nay
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                Room h = new Room();
                h.setIdRoom(rs.getInt("idRoom"));
                h.setNameRoom(rs.getString("nameRoom"));
                listST.add(h);
            }
        } catch (SQLException e) {
        }
        return listST;
    }

    public List<Flat> getAllFlat() {
        List<Flat> listFlat = new ArrayList<>();
        try {
            connectSQL = connect.getJDBCConnection();
            String sql1 = "Select * from ltm. flat  ";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);

            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                Flat f = new Flat();
                f.setIdFlat(rs.getInt("idFlat"));
                f.setNameFlat(rs.getString("nameFlat"));
                listFlat.add(f);
            }
        } catch (SQLException e) {
        }
        return listFlat;
    }

    public void updateRoomforStudent(int id, int idRoom) {
        try {
            connectSQL = connect.getJDBCConnection();
            String sql1 = "UPDATE users SET idRoom_User =? WHERE idUser= ?";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            pre.setInt(1, idRoom);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Room> ListRoom(String namOrNu) {
        List<Room> stringList1 = new ArrayList<>();
        try {
            String sql1 = "select room.idRoom,nameRoom,room.gender,amount,count(room.idRoom) as currentAmount,nameHouse,nameFlat "
                    + "from account join room on account.idRoom=room.idRoom join flat on room.idFlat=flat.idFlat join house on room.idHouse=house.idHouse "
                    + "where room.gender = '" + namOrNu + "' "
                    + "group by idRoom,nameRoom,gender,amount,nameHouse,nameFlat";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int idRoom = rs.getInt("idRoom");
                String name = rs.getString("nameRoom");
                String gender = rs.getString("gender");
                int amount = rs.getInt("amount");
                int currentAmount = rs.getInt("currentAmount");
                String nameHouse = rs.getString("nameHouse");
                String nameFlat = rs.getString("nameFlat");
                stringList1.add(new Room(idRoom, name, gender, amount, currentAmount, nameHouse, nameFlat));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stringList1;
    }

    public int timRoom(String room, String flat, String house) {
        int id = 0;
        try {
            String sql = "SELECT * FROM ltm.room "
                    + "join flat on room.idFlat=flat.idFlat "
                    + "join house on room.idHouse=house.idHouse where nameRoom='"
                    + room + "' and nameFlat='"
                    + flat + "' and nameHouse='"
                    + house + "'";
            PreparedStatement pre = connectSQL.prepareStatement(sql);
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("idRoom");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void suaRoom(int idRoom, int code) {
        int id = 0;
        String sql = "UPDATE  account SET idRoom='"
                + idRoom + "' WHERE code='"
                + code + "'";
        PreparedStatement pre;
        try {
            pre = connectSQL.prepareStatement(sql);
            pre.setInt(1, idRoom);
            pre.setInt(2, code);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findStatusByIdUser() {
        String status = "";
        try {
            String sql = "SELECT * FROM account where idStudent = " + AccStatic.getIdStudent();
            PreparedStatement pre = connectSQL.prepareStatement(sql);
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    List<Account> ListUserOfRoom(int idRoom) {
        List<Account> stringList1 = new ArrayList<>();
        try {
            String sql1 = "Select account.idStudent,account.code,account.password,account.name,account.age,account.gender,account.className,account.status,account.history,room.nameRoom"
                    + " from account \n"
                    + " JOIN room ON account.idRoom=room.idRoom \n"
                    + "  where account.idRoom ='" + idRoom + "' and account.status like 'yes'";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("idStudent");
                int code = rs.getInt("code");
                String pass = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String nameClass = rs.getString("className");
                String status = rs.getString("status");
                String history = rs.getString("history");
                String nameRoom = rs.getString("nameRoom");
                stringList1.add(new Account(id, code, pass, name, age, gender, nameClass, status, history, nameRoom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }

    List<Room> ListRoom() {
        List<Room> stringList1 = new ArrayList<>();
        try {
            String sql1 = "select room.idRoom,nameRoom,room.gender,amount,count(room.idRoom) as currentAmount,nameHouse,nameFlat "
                    + "from account join room on account.idRoom=room.idRoom join flat on room.idFlat=flat.idFlat join house on room.idHouse=house.idHouse "
                    + "where account.status like 'yes' "
                    + "group by idRoom,nameRoom,gender,amount,nameHouse,nameFlat";
            PreparedStatement pre;
            pre = connectSQL.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery(sql1);
            while (rs.next()) {
                int idRoom = rs.getInt("idRoom");
                String name = rs.getString("nameRoom");
                String gender = rs.getString("gender");
                int amount = rs.getInt("amount");
                int currentAmount = rs.getInt("currentAmount");
                String nameHouse = rs.getString("nameHouse");
                String nameFlat = rs.getString("nameFlat");
                stringList1.add(new Room(idRoom, name, gender, amount, currentAmount, nameHouse, nameFlat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringList1;
    }
}
