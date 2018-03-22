/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavenpizza.pizzashoporder;
/**
 * @author Sonali
 *
 */
import java.util.ArrayList; 
import java.util.Collections;  

 public class OrderNumberSorter {
      
  ArrayList<PizzaOutputFile> pizzaoutputfile = new ArrayList<>();   
  
  public OrderNumberSorter(ArrayList<PizzaOutputFile> pizzaoutputfile) { 
      
      this.pizzaoutputfile = pizzaoutputfile; 
  }        
                
  public ArrayList<PizzaOutputFile> getSortedOrderTime() {         
    Collections.sort(pizzaoutputfile);         
    return pizzaoutputfile;     
  } 
       
}
