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
public class Tables {

    private int id;
    private String name;
    private String note;
    private int status;

    public Tables() {
    }

    public Tables(int id, String name, String note, int status) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.status = status;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Tables(String name, String note, int status) {
        this.name = name;
        this.note = note;
        this.status = status;
    }

}
