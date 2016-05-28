package com.j2.w12.Iterator;

import java.util.ArrayList;

public class PancakeHouseMenu implements Menu{
//  static final int MAX_ITEMS=3;
  //int numberOfItems=0;
  //MenuItem[] menuItems;
  ArrayList menuItems;
  public PancakeHouseMenu(){
    menuItems= new ArrayList();
    // menuItems=new MenuItem[MAX_ITEMS]; 
    addItem("plain pancake", 
            "plain simple pancake", true, 2.05); 
    addItem("Nutella Pancake", 
            "Very sweet pancake with Nutella Chocolate", false, 4.99); 
    addItem("banana Pancake", 
            "pancake with Banana. Minions like Banana!!", true, 3.89); 
    
  }
  
  public void addItem(String name, String description, boolean vegetarian, double price){
    MenuItem menuItem=new MenuItem(name,description,vegetarian,price);
    //if(numberOfItems>=MAX_ITEMS){
     // System.out.println("Error");
    //}else{
     // menuItems[numberOfItems]=menuItem;
     // numberOfItems=numberOfItems+1;
    //menuItems[0]=menuItem;
    //}
    menuItems.add(menuItem);
  }
  public ArrayList getMenuItems(){
    return menuItems;
  }
  public Iterator createIterator(){
    return new PancakeHouseMenuIterator(menuItems);
  }
  public String toString(){
    return "Pancake house Menu";
  }
}