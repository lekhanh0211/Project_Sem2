/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Form.ManageTable;
import ProjectDb.DbUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BillsDAO {

    private static BillsDAO instance;

    public BillsDAO() {
    }

    public static BillsDAO getInstance() {
        if (instance == null) {
            instance = new BillsDAO();
        }
        return instance;
    }

    public int GetUncheckInvoiceByTableId(int id) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblBills WHERE tablesId = ? AND status = 0");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                Invoices invoices = new Invoices(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Boolean Insert(int id, int accountId, boolean status) {
        Connection con = DbUtility.openConnection();
        try {
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO tblBills(accountId, tablesId, status) VALUES ('" + accountId + "','" + id + "','" + status + "')");
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int GetMaxIdInvoice() {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT MAX(ID) FROM invoice");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }

    public void Update(int id, int totalPrice) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE tblBills SET status= 1, totalPrice = ? WHERE id = ?");
            pstmt.setInt(1, totalPrice);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
//                int i = pstmt.executeUpdate();
//                if (i > 0) {
//                }
        } catch (SQLException ex) {
            Logger.getLogger(BillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
