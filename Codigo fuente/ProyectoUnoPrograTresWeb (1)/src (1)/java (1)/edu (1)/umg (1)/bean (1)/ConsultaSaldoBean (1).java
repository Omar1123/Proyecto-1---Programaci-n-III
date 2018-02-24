/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean;

import edu.umg.bean.contabilidad.Contabilidad;
import edu.umg.bean.model.Cliente;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author elmer
 */
@ViewScoped
@ManagedBean
public class ConsultaSaldoBean implements Serializable{
    
    private String iniciar;
    private Contabilidad contabilidad;
    private String nombre;
    private String apellido;
    private String respuesta;
    private String nit;
    private Cliente cliente;

    public ConsultaSaldoBean() {
        this.iniciar = "";
        this.contabilidad = new Contabilidad();
        cliente = new Cliente();
    }
    
    public String getIniciar() {
        return iniciar;
    }

    public void setIniciar(String iniciar) {
        this.iniciar = iniciar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    public void consultar() throws IOException{
        cliente = new Cliente();
        respuesta = "";
        
        cliente = contabilidad.saldoCliente(nit);
        if(cliente.getNoDocument()==null){
            respuesta = "El cliente no existe";
        }else{
            respuesta = "El saldo es: "+cliente.getBalance();
        }
        
    }
    
}
