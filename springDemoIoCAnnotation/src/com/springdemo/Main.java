package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//IOC Injection of Control
		//Dependency Injection
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(IocConfig.class); //Hangi class onu vermemiz gerekiyor dikkat et 
		//context.refresh();  Context değiştiği zaman bu gerekebilir.
		
		
		
		
		ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
		//Bana bir customerdal için databasede ne yazıyorsa onu newle bana ver demek
		
	    //ICustomerService customerService = context.getBean("service", ICustomerService.class)
		
		//CustomerService bazında da yapabiliriz. Arka planda bu CustomerManager döndürmesini bekliyoruz
		//CustomerManager constructırında ICustomerDala ihtiyacı var referans olayını burda yapman bekleniyor.
		//IOC configde verilir bu 
		
		customerDal.add();
		
	}

}
