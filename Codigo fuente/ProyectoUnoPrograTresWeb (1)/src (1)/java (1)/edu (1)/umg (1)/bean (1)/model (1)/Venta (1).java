/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author elmer
 */
public class Venta implements Serializable{
    
    private String clientName;
    private String lastNameClient;
    private String ProductName;
    private double price;
    private int amount;
    private String dateTime;
    private double total;
    private String typaPayment;
    private double balanceClient;
    private String noCheck;
    private String bankCheck;
    private String noDocumentClient;

    public Venta() {
        this.clientName = "";
        this.ProductName = "";
        this.price = 0;
        this.amount = 0;
        this.dateTime = "";
        this.total = 0;
        this.typaPayment = "";
        this.balanceClient = 0;
        this.noCheck = "";
        this.bankCheck = "";
        this.noDocumentClient = "";
    }

    
    
    public Venta(String clientName, String ProductName, double price, int amount, String dateTime) {
        this.clientName = clientName;
        this.ProductName = ProductName;
        this.price = price;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public Venta(String clientName, String ProductName, double price, int amount) {
        this.clientName = clientName;
        this.ProductName = ProductName;
        this.price = price;
        this.amount = amount;
    }

    public Venta(String clientName, String ProductName, double price, int amount, String dateTime, double total) {
        this.clientName = clientName;
        this.ProductName = ProductName;
        this.price = price;
        this.amount = amount;
        this.dateTime = dateTime;
        this.total = total;
    }

    public Venta(String clientName, String ProductName, double price, int amount, String dateTime, double total, String typaPayment, double balanceClient, String noCheck, String bankCheck) {
        this.clientName = clientName;
        this.ProductName = ProductName;
        this.price = price;
        this.amount = amount;
        this.dateTime = dateTime;
        this.total = total;
        this.typaPayment = typaPayment;
        this.balanceClient = balanceClient;
        this.noCheck = noCheck;
        this.bankCheck = bankCheck;
    }
    
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTypaPayment() {
        return typaPayment;
    }

    public void setTypaPayment(String typaPayment) {
        this.typaPayment = typaPayment;
    }

    public double getBalanceClient() {
        return balanceClient;
    }

    public void setBalanceClient(double balanceClient) {
        this.balanceClient = balanceClient;
    }

    public String getNoCheck() {
        return noCheck;
    }

    public void setNoCheck(String noCheck) {
        this.noCheck = noCheck;
    }

    public String getBankCheck() {
        return bankCheck;
    }

    public void setBankCheck(String bankCheck) {
        this.bankCheck = bankCheck;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getNoDocumentClient() {
        return noDocumentClient;
    }

    public void setNoDocumentClient(String noDocumentClient) {
        this.noDocumentClient = noDocumentClient;
    }
    
    
    
}
