package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //Sen bir konfigrasyon sınıfısın
@ComponentScan("com.springdemo") //@ComponentScan ile asagida database metounda hangi ICustomerDal objesi return edilecekse onu git 
//diger classların arasından bul diyoruz.
@PropertySource("classpath:values.properties")
//PropertySource dosya nerde diye söylüyoruz.

public class IocConfig {
	//bunun config olabilmesi için config annotationa sahip olması gerekir.
	//Ayrıca component scan de olması lazım @ComponentScan("com.springdemo") bu alan
	//Ben bundan sonra xlm değil bu dosyayı kullanmam lazım diye belirtmeliyim.

//XML İÇİNDE YAPILAN BEAN TANIMI BURDA  YAPILIR.
	//Benim database metodum @Bean ifadesiyle xml dosyalarındaki bean'e karsilik geliyor
	//Metod ismi xml dosyalarindaki id'ye karsilik gelir. Baska bir class bu metoda ulasmak
	//context.getBean metodunda parametre olarak database vermeliyim. Bu metod bize bir adet
	//ICustomerDal objesi donecek.
	
	@Bean //Sen bir bean sin
	public ICustomerDal database(){//İnterface döndürücez bana birtane ICUSTOMERDAL ver ya ms ya mysql
		//İkisi de ICustomerDal
		
		return new MySqlCustomerDal();
			
	}
	
	//Benim database metodum @Bean ifadesiyle xml dosyalarındaki bean'e karsilik geliyor
	//Metod ismi xml dosyalarindaki id'ye karsilik gelir. Baska bir class bu metoda ulasmak
	//context.getBean metodunda parametre olarak database vermeliyim. Bu metod bize bir adet
	//ICustomerService objesi donecek ki donmeli de. Mainde kodlari yazarken context.getBean
	//metoduyla ICustomerService objesi donuyorum. Parametre olarak CustomerManger class'ı
	//constructor'ında bir ICustomerDal objesi aldigi icin ve database metodu da bir adet
	//ICustomerDal objesi dondugu icin parametre olarak direkt database metodunu verdim.
	
	
	
	@Bean
	public ICustomerService service(){
		
		return new CustomerManager(database()); //Icustomerdal veriyorsun
			
	}
}
