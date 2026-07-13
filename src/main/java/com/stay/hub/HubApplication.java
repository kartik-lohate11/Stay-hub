package com.stay.hub;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "StayHub Api Doc",
                contact = @Contact(
                        name = "Kartik lohate",
                        email = "kartik@gmail.com",
                        url = "https://localhost:8091/api"
                ),
                description = "A platform that provide all stay residence according to user",
                license = @License(
                        name = "kartik",
                        url = "abc.com"
                ),
                summary = "For learning purpose",
                version = "V1"
        )

)
public class HubApplication {

    public static void main(String[] args) {
        SpringApplication.run(HubApplication.class, args);
    }

}
