package fi.sovelto.cimcorpdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CimcorpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CimcorpDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner alustusMetodi() {
        return args -> {
            System.out.println("Aloiteltiin");
        };
/*
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Aloiteltiin");
            }
        };
*/
    }
}
