package DAO;

import Connection.connectSQL;
import Model.userModel;
import jbcrypt.BCrypt;

import java.sql.*;

public class doDao extends connectSQL {
    public boolean insert(userModel user) {
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
        String sql ="select * from [DangNhap] where Username = " + "'" + Username + "'";
        Connection conn =super.getJDBCConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if(Username.equals(rs.getString("UserName")) && BCrypt.checkpw(Password, rs.getString("Password"))){
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
}
