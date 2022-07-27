/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DAO;

import Project.Entities.Tables;
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
public class TablesDAO {

    private static TablesDAO instance;

    public TablesDAO() {
    }

    public static TablesDAO getInstance() {
        if (instance == null) {
            instance = new TablesDAO();
        }
        return instance;
    }

    public static void setInstance(TablesDAO instance) {
        TablesDAO.instance = instance;
    }

    public List<Tables> LoadListTables() {
        List<Tables> listTable = new ArrayList<>();

        Connection con = DbUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tblTables");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tables tables = new Tables(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listTable.add(tables);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }

}