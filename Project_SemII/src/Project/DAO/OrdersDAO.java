/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Entities.Orders;
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
public class OrdersDAO {

    private static OrdersDAO instance;

    public OrdersDAO() {
    }

    public static OrdersDAO getInstance() {
        if (instance == null) {
            instance = new OrdersDAO();
        }
        return instance;
    }

    public List<Orders> ListOrder(int id) {
        List<Orders> list = new ArrayList<>();
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblOrders WHERE billId = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(orders);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Boolean Insert(int drinksId, int billId, int quantity) {
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tblOrders VALUES (?,?,?)");
            pstmt.setInt(1, drinksId);
            pstmt.setInt(2, quantity);
            pstmt.setInt(3, billId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
