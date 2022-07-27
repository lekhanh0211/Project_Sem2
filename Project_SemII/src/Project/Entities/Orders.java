/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Entities;

/**
 *
 * @author Admin
 */
public class Orders {

    private int id;
    private int drinksId;
    private int quantity;
    private int billId;

    public Orders() {
    }

    public Orders(int id, int drinksId, int quantity, int billId) {
        this.id = id;
        this.drinksId = drinksId;
        this.quantity = quantity;
        this.billId = billId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrinksId() {
        return drinksId;
    }

    public void setDrinksId(int drinksId) {
        this.drinksId = drinksId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

}
