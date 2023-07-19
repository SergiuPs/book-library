package de.pislaru.sergiu.booklibrary.address.service;

import de.pislaru.sergiu.booklibrary.address.AddressDTO;
import de.pislaru.sergiu.booklibrary.model.address.Address;
import de.pislaru.sergiu.booklibrary.repositories.AddressRepository;
import de.pislaru.sergiu.booklibrary.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressDTO> getAllByUserId(Long userId) {
        List<Address> addresses = addressRepository.findAllByUserIdOrderByIdAsc(userId);
        return ModelMapperUtils.mapList(addresses, AddressDTO.class, modelMapper);
    }
}
