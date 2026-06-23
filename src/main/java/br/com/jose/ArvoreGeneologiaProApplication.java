package br.com.jose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringBootTest(classes = ArvoreGeneologiaProApplication.class)
@ComponentScan(basePackages = "br.com.jose") // garante que tudo em br.com.jose e subpacotes será escaneado
public class ArvoreGeneologiaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArvoreGeneologiaProApplication.class, args);
      
        
        
        
    }
    

}