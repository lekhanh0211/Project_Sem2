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

    List<Tables> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
//    private static TablesDAO instance;
//
//    public TablesDAO() {
//    }
//
//    public static TablesDAO getInstance() {
//        if (instance == null) {
//            instance = new TablesDAO();
//        }
//        return instance;
//    }
//
//    public static void setInstance(TablesDAO instance) {
//        TablesDAO.instance = instance;
//    }

    public List<Tables> LoadListTables() {
        List<Tables> list = new ArrayList<>();

        Connection con = DbUtility.openConnection();
        try {
            pstm = con.prepareStatement("SELECT * FROM tblTables");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Tables tables = new Tables(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                list.add(tables);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Tables t) {
        try {
            Connection con = DbUtility.openConnection();
            String query = "update tblTables set name=?, note=?,status=? where id=?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setString(2, t.getNote());
            pstm.setInt(3, t.getStatus());
            pstm.setInt(4, t.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String name, String note, int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
