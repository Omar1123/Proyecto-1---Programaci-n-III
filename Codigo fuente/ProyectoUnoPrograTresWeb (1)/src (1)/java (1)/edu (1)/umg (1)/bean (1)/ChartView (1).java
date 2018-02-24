/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.bean;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author elmer
 */
@ManagedBean
public class ChartView implements Serializable{
    
    private CartesianChartModel combinedModel;
 
    @PostConstruct
    public void init() {
        createCombinedModel();
    }
 
    public CartesianChartModel getCombinedModel() {
        return combinedModel;
    }
     
    private void createCombinedModel() {
        combinedModel = new BarChartModel();
 
        BarChartSeries boys = new BarChartSeries();
        boys.setLabel("Dulces (Compras)");
 
        boys.set("2013", 120);
        boys.set("2014", 100);
        boys.set("2015", 44);
        boys.set("2016", 150);
        boys.set("2017", 25);
 
        LineChartSeries girls = new LineChartSeries();
        girls.setLabel("Ventas");
 
        girls.set("2013", 52);
        girls.set("2014", 60);
        girls.set("2015", 110);
        girls.set("2016", 135);
        girls.set("2017", 120);
 
        combinedModel.addSeries(boys);
        combinedModel.addSeries(girls);
         
        combinedModel.setTitle("Compras/Ventas Ultimos 5 años");
        combinedModel.setLegendPosition("ne");
        combinedModel.setMouseoverHighlight(false);
        combinedModel.setShowDatatip(false);
        combinedModel.setShowPointLabels(true);
        Axis yAxis = combinedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
    
}
