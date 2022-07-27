/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Entities.Account;
import ProjectDb.DbUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    private static AccountDAO instance;
    Account account = new Account();

    public AccountDAO() {
    }

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    public static void setInstance(AccountDAO instance) {
        AccountDAO.instance = instance;
    }

    public Boolean Login(String username, String password) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblAccount WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setName(rs.getString(4));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Account GetAccount() {
        return account;
    }

    public List<Account> listAccount() {
        List<Account> list = new ArrayList<>();
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblAccount");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Account ac = new Account();
                ac.setId(rs.getInt("id"));
                ac.setName(rs.getString("name"));
                ac.setUsername(rs.getString("username"));
                ac.setPassword(rs.getString("password"));
                list.add(ac);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Add(String name, String username, String pass) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tblAccount VALUES (?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, pass);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(int id, String name, String pass) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE tblAccount SET name=?,password=? WHERE id=?");
            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            pstmt.setInt(3, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Delete(int id) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from tblAccount where id=?");
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean DoiMatKhau(int id, String pass) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE tblAccount SET password=? WHERE id=?");
            pstmt.setString(1, pass);
            pstmt.setInt(2, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().listAccount().size());
    }
}
