package com.springdemo;

//import org.springframework.beans.factory.annotation.Value;

//import org.springframework.stereotype.Component;

//@Component("database") //Annotation ile bu şekilde çalışıyor. Bunu tek bir yere yazmam
//gerekiyor. Ben burda diyorum ki sen databasesin. 
//Örneğin sen git bütün classların tepesine bak hangisinde database varsa onu newle diye taratıyoruz.
//Component sil diğer tarafa at falan unutabileceğin şeyler. IOC config içinde Bean tanımı yapılacak.

public class MsSqlCustomerDal implements ICustomerDal {
	//@Value("${database.connectionString}")
    String connectionString;
	

	public String getConnectionString() {
		return connectionString;
	}


	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Connection String "+this.connectionString);
		System.out.println("Ms Sql veritabanına eklendi...");
		
	}

}
