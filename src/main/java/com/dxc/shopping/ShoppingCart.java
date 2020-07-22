package com.dxc.shopping;

import java.util.Scanner;
import com.dxc.shopping.model.*;
import com.dxc.shopping.service.*;

import com.dxc.shopping.exception.ProductException;
import com.dxc.shopping.model.Product;
import com.dxc.shopping.service.CartOperationService;
import com.dxc.shopping.service.CartOperationServiceImpl;
public class ShoppingCart 
{
    public static void main( String[] args ) throws ProductException
    {  
    	float price;int Qty;String name;int temp;int i;
    	CartOperationService coi= new CartOperationServiceImpl(10);
        Scanner ip=new Scanner(System.in);
        Product[] p= new Product[5];
        try
        {
        coi.removeFromCart(p[0]);
        }finally 
        {
        for(i=0;i<5;i++)
        {
        	System.out.println("Enter the details of product (Name,Price,Quantity)  No:"+(i+1));
        	name=ip.nextLine();
        	price=Float.parseFloat(ip.nextLine());
        	Qty=Integer.parseInt(ip.nextLine());
        	p[i]=new Product(name,price,Qty);
        	System.out.println("Amount to Pay  :"+coi.addToCart(p[i]));
        }
        
       
        System.out.println("Total Invoice Amount  :"+coi.getInvoiceAmount());
        System.out.println("Do you Want to remove any item(Y/N)");
        char c=ip.next().charAt(0);
        if((c=='Y')||(c=='y'))
        {   
        	System.out.println("Enter the Product Number  :");
        	temp=ip.nextInt();
        	try {
        	coi.removeFromCart(p[temp-1]);}
        	catch(ProductException PE)
        	{
        		System.out.println(PE);
        	}
        	System.out.println("Removed Product :"+p[temp-1].getName());
        	System.out.println("Total Invoice After removal  :"+coi.getInvoiceAmount());
        	
        }
        	
        
        
       
        else
        {
        	System.out.println("Pay Rupees  :"+coi.getInvoiceAmount());
        }
        
    }
}
}
