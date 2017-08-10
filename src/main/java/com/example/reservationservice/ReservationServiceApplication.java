package com.example.reservationservice;

import com.example.reservationservice.domain.Reservation;
import com.example.reservationservice.repositories.ReservationRepository;
import java.util.Locale;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class ReservationServiceApplication {
//extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
    
    @Bean
    CommandLineRunner init(ReservationRepository rr) {
        return args -> {
            Stream.of("Josh", "Heidi", "Cameron", "Saritha",
                    "Balaji", "Soumya", "Steve", "Kelsey")
                    .forEach(name -> rr.save(new Reservation(name)));

            rr.findAll().forEach(System.out::println);
        };
    }
         
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.US);
//        return slr;
//    }
// 
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
// 
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages");
//        messageSource.setCacheSeconds(3600);
//        return messageSource;
//    }
//    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
 
}