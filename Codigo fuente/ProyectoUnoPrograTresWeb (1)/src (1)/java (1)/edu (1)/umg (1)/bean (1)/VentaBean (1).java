/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean;

import edu.umg.bean.contabilidad.Contabilidad;
import edu.umg.bean.handler.Handler;
import edu.umg.bean.model.Cliente;
import edu.umg.bean.model.Venta;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author elmer
 */
@SessionScoped
@ManagedBean
public class VentaBean implements Serializable{
    
    private List<Venta> ventas;
    private List<Venta> ventasFilt;
    private Venta venta;
    private Handler handler;
    private String tipoPago;
    private Contabilidad contabilidad;
    private String iniciar;
    
    private static final Logger LOG = Logger.getLogger(VentaBean.class.getName());

    public VentaBean() {
        handler = new Handler();
        ventas = new ArrayList<Venta>();
        venta = new Venta();
        contabilidad = new Contabilidad();
        mostrarVentas();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Venta> getVentasFilt() {
        return ventasFilt;
    }

    public void setVentasFilt(List<Venta> ventasFilt) {
        this.ventasFilt = ventasFilt;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getIniciar() {
        return iniciar;
    }

    public void setIniciar(String iniciar) {
        this.iniciar = iniciar;
    }
    
    public void mostrarVentas(){
        ventas = handler.mostrarVentas();
    }
    
    public void agregarVenta() throws IOException{
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        venta.setDateTime(obtenerFecha());
        venta.setTotal(venta.getPrice()*venta.getAmount());
        venta.setTypaPayment(tipoPago);
        venta.setBalanceClient(0);
        if(tipoPago.equals("Credito")){
            venta.setBalanceClient(venta.getTotal());
            contabilidad.crearRelacion(venta.getClientName(),venta.getLastNameClient(),-venta.getBalanceClient(),venta.getDateTime(),venta.getNoDocumentClient());
        }else{
           contabilidad.crearRelacion(venta.getClientName(),venta.getLastNameClient(),venta.getTotal(),venta.getDateTime(),venta.getNoDocumentClient()); 
        }
        
                
        handler.agregarVenta(venta);
        ventas.add(venta);
        venta = new Venta();
        
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta exitosa","La venta fue registrada.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    private String obtenerFecha() {
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
         Date today = Calendar.getInstance().getTime();        
         String purcharseDate = df.format(today);
         return purcharseDate;
    }
    
    
    
}
