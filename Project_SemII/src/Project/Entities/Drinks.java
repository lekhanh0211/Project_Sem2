/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Drinks {

    private int id;
    private String name;
    private float price;
    private String description;
    private Date expireDate;
    private Boolean status;

    public Drinks() {
    }

    public Drinks(int id, String name, float price, String description, Date expireDate, Boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.expireDate = expireDate;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpireDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(expireDate);
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
