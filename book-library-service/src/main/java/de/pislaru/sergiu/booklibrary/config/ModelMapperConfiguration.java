package de.pislaru.sergiu.booklibrary.config;

import de.pislaru.sergiu.booklibrary.commands.address.AddressCommand;
import de.pislaru.sergiu.booklibrary.model.address.Address;
import de.pislaru.sergiu.booklibrary.model.address.AddressInfo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(AddressCommand.class, AddressInfo.class).addMappings(mapper -> {
            mapper.map(AddressCommand::getCity, AddressInfo::setCityInfo);
        });

        modelMapper.typeMap(AddressCommand.class, AddressInfo.class).addMappings(mapper -> {
            mapper.map(AddressCommand::getUserCommand, AddressInfo::setUserInfo);
        });

        modelMapper.typeMap(Address.class, AddressInfo.class).addMappings(mapper -> {
            mapper.map(Address::getCity, AddressInfo::setCityInfo);
        });

        modelMapper.typeMap(Address.class, AddressInfo.class).addMappings(mapper -> {
            mapper.map(Address::getUser, AddressInfo::setUserInfo);
        });

        return modelMapper;
    }
}
