package com.skunfly.config;

import com.skunfly.soap.client.GenericSOAPClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SOAPClientConfiguration {

    @Bean
    public Jaxb2Marshaller weatherMarshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPath("com.skunfly.weather.wsdl");

        return marshaller;
    }

    @Bean
    public GenericSOAPClient weatherClient(@Qualifier(value = "weatherMarshaller") Jaxb2Marshaller marshaller,
                                           @Value("${weather.url}") String uri) {
        return new GenericSOAPClient(marshaller, uri);
    }

}
