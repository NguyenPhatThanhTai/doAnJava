package DAO;

import Connection.connectSQL;
import Model.customerModel;
import Model.userModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jbcrypt.BCrypt;

import java.sql.*;

public class doDao extends connectSQL {
    public boolean insertCustomer(userModel user) {
//        int roleId = 0;
        String sql ="INSERT INTO [DangNhap](Id, email, userName, passWord, roleID) VALUES (?,?,?,?,?)";
        Connection conn =super.getJDBCConnection();
        String HashPass = BCrypt.hashpw(user.getPassWord(), BCrypt.gensalt(12));
        System.out.println(HashPass);
        try{
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserName());
            ps.setString(4, HashPass);
            ps.setInt(5, user.getRoleID());


//            try{
//                if(user.getRoleID() == 1){
//                    roleId = 1;
//                }
//                else {
//                    roleId = 2;
//                }
//
//            }catch (Exception e){
//                roleId = 2;
//            }
//            ps.setInt(4,roleId);
            ps.executeUpdate();
            ps.close();
            return true;
            //SQLException khác với Exception=======================
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkLogin(String Username, String Password){
        boolean check = false;
        String sql ="select * from [Account_Staff] where Staff_Account = " + "'" + Username + "'";
        Connection conn =super.getJDBCConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
//                if(Username.equals(rs.getString("Staff_Account")) && BCrypt.checkpw(Password, rs.getString("Staff_Password"))){
                if(Username.equals(rs.getString("Staff_Account")) && Password.equals(rs.getString("Staff_Password"))){
                    check = true;
                }
            }
            else {
                check = false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }

    public ObservableList<customerModel> getAllCustomer(){
        String sex = "";
        String sql ="select * from [Inf_Customers]";
        Connection conn =super.getJDBCConnection();
        ObservableList<customerModel> list = FXCollections.observableArrayList();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                if (rs.getString("Customer_Sex").equals("1")){
                    sex = "Nam";
                }
                else {
                    sex = "Nữ";
                }
                list.add(new customerModel(rs.getString("Customer_Id"), rs.getString("Customer_Name"),
                        sex, rs.getString("Customer_Birth"), rs.getString("Customer_Email"),
                        rs.getString("Customer_Phone"), rs.getString("Customer_TimeAdd")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
