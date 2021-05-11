package com.springdemo;

public class CustomerManager implements ICustomerService{

	
	private ICustomerDal customerDal;
	
	//CustomerManager parametre olarak bir ICUSTOMERDAL istiyor ve onun add ini çalıştırıyor.
	//Constructor injection 
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}


	public void add() {
		
		customerDal.add();
		
		
	}
	
	
}
