package de.pislaru.sergiu.booklibrary.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.pislaru.sergiu.booklibrary.domain.entity.user.Role;
import de.pislaru.sergiu.booklibrary.user.dto.RoleDTO;
import de.pislaru.sergiu.booklibrary.domain.entity.address.Address;
import de.pislaru.sergiu.booklibrary.address.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Address.class, AddressDTO.class).addMappings(mapper -> {
            mapper.map(Address::getCity, AddressDTO::setCity);
        });

        modelMapper.typeMap(Role.class, RoleDTO.class).addMappings(mapper -> {
            mapper.map(Role::getPermissions, RoleDTO::setPermissions);
        });

        return modelMapper;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}
