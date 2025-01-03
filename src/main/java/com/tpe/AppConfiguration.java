package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration//bu classta yapılandırma ayarları verilecek
@ComponentScan("com.tpe")//bu pathde yer alan tüm componentların tarar
//default path:AppConfiguration classının içinde bulunduğu path tanımlıdır.
public class AppConfiguration {

    //bean anatosyanı configre icinde üretiliyor
    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    //componunnt anatosyonu gibi burdaki objenin üretilmesini ve yönetimini spring e verir
    public Random random(){
        return new Random();
    }


    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }


}
