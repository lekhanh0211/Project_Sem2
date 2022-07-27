/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Entities;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Drinks {

    private int id;
    private String name;
    private float price;
    private Date importDate;
    private Date expiry;

    public Drinks() {
    }

    public Drinks(int id, String name, float price, Date importDate, Date expiry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.importDate = importDate;
        this.expiry = expiry;
    }

    public Drinks(int i, String _Chọn_đồ_uống_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
