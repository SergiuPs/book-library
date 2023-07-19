package de.pislaru.sergiu.booklibrary.address.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import de.pislaru.sergiu.booklibrary.address.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAllByUserId(Long userId);
}
