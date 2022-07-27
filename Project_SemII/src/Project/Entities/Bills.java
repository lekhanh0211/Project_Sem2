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
public class Bills {

    private int id;
    private int accountId;
    private Date billDate;
    private int tablesId;
    private boolean status;
    private float totalPrice;

    public Bills() {
    }

    public Bills(int id, int accountId, Date billDate, int tablesId, boolean status, float totalPrice) {
        this.id = id;
        this.accountId = accountId;
        this.billDate = billDate;
        this.tablesId = tablesId;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
