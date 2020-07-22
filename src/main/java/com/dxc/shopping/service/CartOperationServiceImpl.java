package com.dxc.shopping.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.dxc.shopping.exception.ProductException;
import com.dxc.shopping.model.Product;

public class CartOperationServiceImpl implements CartOperationService{
	private float tax_percentage;
	private float invoiceAmount=0; 
	
	ArrayList<Product> cart=new ArrayList<Product>();
	
	
	public CartOperationServiceImpl(float tax_percentage) 
	{
		this.tax_percentage=tax_percentage;
	}

	
	public float getInvoiceAmount()
	{
		return invoiceAmount;
	}
	public float addToCart(Product p)
	{
		cart.add(p);
		float tax=((p.getPrice())*p.getQuantity())*tax_percentage/100;
		invoiceAmount=invoiceAmount+(p.getPrice()*p.getQuantity())+tax;
		return invoiceAmount;
		
	}
	public void removeFromCart(Product p) throws ProductException
	{  
		
		//Iterator<Product> iterator=cart.iterator();
		
		try
	    {
		if(cart.isEmpty())
		{
			throw new ProductException("Exception Occured while removing product when the cart is Empty");
		}
	    }catch(ProductException i)
		{
			System.out.println(i);
		}
	
	

		float tax=(p.getPrice()*p.getQuantity())*tax_percentage/100;
		invoiceAmount-=p.getPrice()*p.getQuantity()+tax;	
		
		
			
	}

}

