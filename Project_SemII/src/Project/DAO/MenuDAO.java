/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Entities.Menu;
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
public class MenuDAO {

    private static MenuDAO instance;

    public MenuDAO() {
    }

    public static MenuDAO getInstance() {
        if (instance == null) {
            instance = new MenuDAO();
        }
        return instance;
    }

    public static void setInstance(MenuDAO instance) {
        MenuDAO.instance = instance;
    }

    public List<Menu> GetListMenuByTableId(int id) {
        List<Menu> list = new ArrayList<>();
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT drinks.name, orders.quantity, drinks.price, orders.quantity*drinks.price AS totalPrice FROM orders, invoice, drinks\n"
                    + "                    WHERE orders.invoice_ID = invoice.ID AND orders.drinks_ID = drinks.ID \n"
                    + "                    AND invoice.status = 1 AND invoice.tables_id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
