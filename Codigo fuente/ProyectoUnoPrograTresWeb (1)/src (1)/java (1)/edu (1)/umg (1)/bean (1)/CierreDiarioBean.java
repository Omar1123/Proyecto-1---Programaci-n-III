/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean;

import edu.umg.bean.contabilidad.Contabilidad;
import edu.umg.bean.handler.Handler;
import edu.umg.bean.model.Venta;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author elmer
 */
@ViewScoped
@ManagedBean
public class CierreDiarioBean{
    
    private double totalADepositar;
    private double totalCaja;
    private int bDiez;
    private int bCinco;
    private int bCincuenta;
    private int bCien;
    private int bDoscientos;
    private int bUnQ;
    private int bCincCen;
    private Contabilidad contabilidad;
    private Handler handler;
    private List<Venta> ventas;

    public CierreDiarioBean() {
        this.totalADepositar = 0.0;
        this.bDiez = 0;
        this.bCinco = 0;
        this.bCincuenta = 0;
        this.bCien = 0;
        this.bDoscientos = 0;
        this.bUnQ = 0;
        this.bCincCen = 0;
        this.totalCaja = 0.0;
        contabilidad = new Contabilidad();
        handler = new Handler();
        totalADep();
    }
    
    

    public double getTotalADepositar() {
        return totalADepositar;
    }

    public void setTotalADepositar(double totalADepositar) {
        this.totalADepositar = totalADepositar;
    }

    public int getbDiez() {
        return bDiez;
    }

    public void setbDiez(int bDiez) {
        this.bDiez = bDiez;
    }

    public int getbCinco() {
        return bCinco;
    }

    public void setbCinco(int bCinco) {
        this.bCinco = bCinco;
    }

    public int getbCincuenta() {
        return bCincuenta;
    }

    public void setbCincuenta(int bCincuenta) {
        this.bCincuenta = bCincuenta;
    }

    public int getbCien() {
        return bCien;
    }

    public void setbCien(int bCien) {
        this.bCien = bCien;
    }

    public int getbDoscientos() {
        return bDoscientos;
    }

    public void setbDoscientos(int bDoscientos) {
        this.bDoscientos = bDoscientos;
    }

    public int getbUnQ() {
        return bUnQ;
    }

    public void setbUnQ(int bUnQ) {
        this.bUnQ = bUnQ;
    }

    public int getbCincCen() {
        return bCincCen;
    }

    public void setbCincCen(int bCincCen) {
        this.bCincCen = bCincCen;
    }

    public double getTotalCaja() {
        return totalCaja;
    }

    public void setTotalCaja(double totalCaja) {
        this.totalCaja = totalCaja;
    }
    
    public void totalADep(){
        
        ventas = new ArrayList<>();
        
        totalADepositar = contabilidad.totalAPagarBanco();
        
    }
    
    public void calcularMontos(){
        totalCaja = 0;
        totalCaja = totalCaja + (bDiez*10);
        totalCaja = totalCaja + (bCinco*5);
        totalCaja = totalCaja + (bCincuenta*50);
        totalCaja = totalCaja + (bCien*100);
        totalCaja = totalCaja + (bDoscientos*200);
        totalCaja = totalCaja + (bUnQ*1);
        totalCaja = totalCaja + (bCincCen*0.50);
        totalCaja = totalCaja + (bDiez*10);
        
        
    }
    
    public void ejecutarCierre(){
        FacesMessage msg = null;
        
        totalADep();
        
        if(totalCaja==totalADepositar){
            
            handler.agregarCierre(totalADepositar, bDiez, bCinco, bCincuenta, bCien, bDoscientos, bUnQ, bCincCen, totalCaja, obtenerFecha());
            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cierre exitoso","El cierre diario fue ejecutado exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.totalADepositar = 0.0;
            this.bDiez = 0;
            this.bCinco = 0;
            this.bCincuenta = 0;
            this.bCien = 0;
            this.bDoscientos = 0;
            this.bUnQ = 0;
            this.bCincCen = 0;
            this.totalCaja = 0.0;
        }else{
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cierre no exitoso","El total de caja no fue contabilizado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    
    private String obtenerFecha() {
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
         Date today = Calendar.getInstance().getTime();        
         String purcharseDate = df.format(today);
         return purcharseDate;
    }
    
}
