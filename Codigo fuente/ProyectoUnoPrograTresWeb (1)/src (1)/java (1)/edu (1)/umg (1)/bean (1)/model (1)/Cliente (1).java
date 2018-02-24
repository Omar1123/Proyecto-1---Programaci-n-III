/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean.model;

import java.io.Serializable;

/**
 *
 * @author elmer
 */
public class Cliente implements Serializable{
    
    private String noDocument;
    private String name;
    private String lastName;
    private double balance;

    public Cliente(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cliente(String name, String lastName, double balance) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Cliente(String noDocument, String name, String lastName, double balance) {
        this.noDocument = noDocument;
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
    }
    
    
    
    public Cliente() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNoDocument() {
        return noDocument;
    }

    public void setNoDocument(String noDocument) {
        this.noDocument = noDocument;
    }

    
    
    
    
}
