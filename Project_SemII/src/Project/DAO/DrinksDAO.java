/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Entities.Drinks;
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
public class DrinksDAO {

    private static DrinksDAO dao;

    public DrinksDAO() {
    }

    public static DrinksDAO getInstance() {
        if (dao == null) {
            dao = new DrinksDAO();
        }
        return dao;
    }

    public List<Drinks> GetListDrink() {
        List<Drinks> list = new ArrayList<>();
        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblDrinks");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Drinks drinks = new Drinks(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getDate(5));
                list.add(drinks);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DrinksDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
