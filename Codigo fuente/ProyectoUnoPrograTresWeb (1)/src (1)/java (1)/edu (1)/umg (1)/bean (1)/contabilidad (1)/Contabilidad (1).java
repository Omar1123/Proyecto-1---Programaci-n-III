/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean.contabilidad;

import edu.umg.bean.handler.Handler;
import edu.umg.bean.model.Cliente;
import edu.umg.bean.model.Venta;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elmer
 */
public class Contabilidad implements Serializable {
    private List<Cliente> clientes;
    private Cliente cliente;
    private String iniciar;
    private Handler handler;
    
    public Contabilidad(){
        cliente = new Cliente();
        clientes = new ArrayList<Cliente>();
        handler = new Handler();
    }

    public String getIniciar() {
        return iniciar;
    }

    public void setIniciar(String iniciar) {
        this.iniciar = iniciar;
    }
    
    public void crearRelacion(String nombre,String apellido,double venta,String fecha,String noDocumento) throws IOException{
        
        cliente.setName(nombre);
        cliente.setLastName(apellido);
        cliente.setBalance(venta);
        cliente.setNoDocument(noDocumento);
        clientes.add(cliente);
        
        handler.agregarCliente(cliente.getName(),cliente.getLastName(),venta,fecha,noDocumento);
        
        System.out.println("TAMANIOADD: "+clientes.size());
        
        
    }
    
    
    public Cliente saldoCliente(String nit) throws IOException{
        
        Cliente respuesta;
        respuesta = new Cliente();
        
        String noDocUno;
        String noDocDos;
        noDocUno = "";
        noDocDos = "";
        double saldo;
        saldo = 0;
        
        boolean bandera;
        bandera = false;
        
        noDocUno = nit.trim();
        
        System.out.println("TAMANIO: "+clientes.size());
        
        for(Cliente cl:handler.mostrarClientesBack()){
            noDocDos = cl.getNoDocument().trim();
            System.out.println("CLIENTEUNO: "+noDocUno);
            System.out.println("CLIENTEDOS: "+noDocDos);
            
            if(noDocUno.equals(noDocDos)){
                if(cl.getBalance()<0){
                    saldo = saldo + cl.getBalance();
                }
                respuesta = cl;
                bandera = true;
            }
        }
        
        respuesta.setBalance(saldo);
        
        return respuesta;
        
    }
    
    public double totalAPagarBanco(){
        
        List<Venta> ventas;
        ventas = new ArrayList<>();
        ventas = handler.muestraVentasDia();
        double totalADepositar;
        totalADepositar = 0;
        
        for(Venta venta: ventas){
            totalADepositar = totalADepositar + venta.getTotal();
        }
        return totalADepositar;
    }
    
    
}
