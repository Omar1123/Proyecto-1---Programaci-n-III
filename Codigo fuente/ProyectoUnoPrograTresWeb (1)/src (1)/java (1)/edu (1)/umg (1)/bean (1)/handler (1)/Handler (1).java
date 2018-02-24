/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umg.bean.handler;

import edu.umg.bean.model.Cliente;
import edu.umg.bean.model.Venta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jake
 */
public class Handler implements Serializable{
    
    private String clientName;
    private String ProductName;
    private double price;
    private double amount;
    private String dateTime;
    private int option;
    
    //File import
    
    private FileOutputStream fileStream;
    private String pathVenta = "/Users/elmer/NetBeansProjects/ProyectoUnoPrograTres/StoreUniversity/src/STORE.txt";
    private String pathCierre = "/Users/elmer/NetBeansProjects/ProyectoUnoPrograTres/StoreUniversity/src/CIERRE.txt";
    private String pathCliente = "/Users/elmer/NetBeansProjects/ProyectoUnoPrograTres/StoreUniversity/src/Client.txt";
    private File FILENAME = new File(pathVenta);
    private File FILENAMECLIENT = new File(pathCliente);
    private File FILENAMECIERRE = new File(pathCierre);
    private DataOutputStream data;    
    
    public Handler() {
        clientName = "";
        ProductName = "";
        price = 0.0;
        amount = 0;
        dateTime = "";
        option = 0;
    }
    
    public void agregarVenta(Venta venta) {
        
        crearArchivo(FILENAME);
        
        try {

            

            agregarVentaArchivo(FILENAME,venta.getNoDocumentClient(), venta.getClientName(),venta.getLastNameClient(), venta.getProductName(), 
                    venta.getPrice(), venta.getAmount(),venta.getTotal(),venta.getTypaPayment(),venta.getBalanceClient(),venta.getNoCheck()
                    ,venta.getBankCheck(), venta.getDateTime()); 
        } catch(Exception ex) {
            System.out.println("Revisa los formatos de lo que has ingresado");
            //doPurchase();
        }             
    }
    
    public void agregarCliente(String clientName,String clienteLastName, double balanceClient,  String dateTimeFile,String noDoc) {
        
        crearArchivoCliente(FILENAMECLIENT);
        
        try {

            

            agregaClienteArchivo(FILENAMECLIENT, clientName,clienteLastName,balanceClient,dateTimeFile,noDoc); 
        } catch(Exception ex) {
            System.out.println("Revisa los formatos de lo que has ingresado");
            //doPurchase();
        }             
    }
      
    public void agregarCierre(double totalADepositar,int bDiez,int bCinco,int bCincuenta,int bCien,
            int bDoscientos,int bUnQ,int bCincCen,double totalCaja,String fecha){
        crearArchivoCierre(FILENAMECIERRE);
        try {
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAMECIERRE,true), "utf-8"));
            
            writter.write(totalADepositar + "," +bDiez + "," +bCinco + "," + bCincuenta + "," + bCien + "," + bDoscientos + 
                    "," + bUnQ + "," + bCincCen + "," + totalCaja+","+fecha + "\r\n");
          
            writter.close();
            
            System.out.println("Se ha realizado con exito el cierre");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void editarCliente(String clientName,String clienteLastName, double balanceClient,  String dateTimeFile,String noDoc) {
        
        crearArchivoCliente(FILENAMECLIENT);
        
        try {

            

            agregaClienteArchivo(FILENAMECLIENT, clientName,clienteLastName,balanceClient,dateTimeFile,noDoc); 
        } catch(Exception ex) {
            System.out.println("Revisa los formatos de lo que has ingresado");
            //doPurchase();
        }             
    }
    
    
   
    private void agregarVentaArchivo(File file,String noDoc ,String clientNameFile,String clienteLasName, String productNameFile, 
            double priceFile, int amountFile,double total, String typaPayment, double balanceClient, String noCheck, String bankCheck, String dateTimeFile) {        
        try {
          
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
            
            writter.write(noDoc + "," +clientNameFile + "," +clienteLasName + "," + productNameFile + "," + priceFile + "," + amountFile + "," + total + "," + typaPayment + "," + balanceClient
                    + "," + noCheck + "," + bankCheck + "," + dateTimeFile + "\r\n");
          
            writter.close();
            
            System.out.println("Se ha realizado con exito su compra");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }      
    }
    
    private void agregaClienteArchivo(File file, String clientName,String clienteLastName, double balanceClient,
            String dateTimeFile,String noDoc) {        
        try {
          
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
            
            writter.write(noDoc + "," +clientName + "," + clienteLastName + "," + balanceClient + "," + dateTimeFile + "\r\n");
          
            writter.close();
            
            System.out.println("Se ha agregado con exito el cliente");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }      
    }
    
    private void crearArchivo(File file) {
        
        System.out.println("Creando el documento con los datos");
        
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
        } 
    }
    
    private void crearArchivoCliente(File file) {
        
        System.out.println("Creando el documento con los datos cliente");
        
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
        } 
    }
    
    private void crearArchivoCierre(File file) {
        
        System.out.println("Creando el documento con los datos del cierre");
        
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
        } 
    }
    
    public List<Cliente> mostrarClientesBack() throws IOException{
    
        String cadena;
        FileReader f = new FileReader(pathCliente);
        BufferedReader b = new BufferedReader(f);
        String[] parts = new String[3];
        List<Cliente> respuesta = new ArrayList<>();
        Cliente cli = new Cliente();
        
        while((cadena = b.readLine())!=null) {
            
            System.out.println(cadena);
            parts = cadena.split(",");
            cli = new Cliente();
            cli.setNoDocument(parts[0]);
            cli.setName(parts[1]);
            cli.setLastName(parts[2]);
            cli.setBalance(Double.parseDouble(String.valueOf(parts[3])));
            respuesta.add(cli);
        }
        b.close();
        System.out.println("SIZE: "+respuesta.size());
        
        return respuesta;
        
    }
    
    
    
    public List<Venta> muestraVentasDia() {
        String cadena;
        List<Venta> respuesta = new ArrayList<>();
        Venta venta = new Venta();
        System.out.println("LLEGA_ACA: ");
        try{
            FileReader f = new FileReader("/Users/elmer/NetBeansProjects/ProyectoUnoPrograTres/StoreUniversity/src/STORE.txt");
            System.out.println("PASA_PATH: ");
            BufferedReader b = new BufferedReader(f);
            String[] parts = new String[7];
            

            while((cadena = b.readLine())!=null) {

                System.out.println(cadena);
                venta = new Venta();
                parts = cadena.split(",");
                if((String.valueOf(parts[7])).equals("Efectivo")){
                    venta.setNoDocumentClient(parts[0]);
                    venta.setClientName(parts[1]);
                    venta.setLastNameClient(parts[2]);
                    venta.setProductName(parts[3]);
                    venta.setPrice(Double.parseDouble(String.valueOf(parts[4])));
                    venta.setAmount(Integer.parseInt(String.valueOf(parts[5])));
                    venta.setTotal(Double.parseDouble(String.valueOf(parts[6])));
                    respuesta.add(venta);
                } 
            }
            b.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Venta> mostrarVentas() {
        String cadena;
        List<Venta> respuesta = new ArrayList<>();
        Venta venta = new Venta();
        System.out.println("LLEGA_ACA: ");
        try{
            FileReader f = new FileReader("/Users/elmer/NetBeansProjects/ProyectoUnoPrograTres/StoreUniversity/src/STORE.txt");
            System.out.println("PASA_PATH: ");
            BufferedReader b = new BufferedReader(f);
            String[] parts = new String[7];
            

            while((cadena = b.readLine())!=null) {

                System.out.println(cadena);
                venta = new Venta();
                parts = cadena.split(",");
                venta.setNoDocumentClient(parts[0]);
                venta.setClientName(parts[1]);
                venta.setLastNameClient(parts[2]);
                venta.setProductName(parts[3]);
                venta.setPrice(Double.parseDouble(String.valueOf(parts[4])));
                venta.setAmount(Integer.parseInt(String.valueOf(parts[5])));
                venta.setTotal(Double.parseDouble(String.valueOf(parts[6])));
                venta.setDateTime(String.valueOf(parts[11]));
                respuesta.add(venta);
                
            }
            b.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }

    
}
