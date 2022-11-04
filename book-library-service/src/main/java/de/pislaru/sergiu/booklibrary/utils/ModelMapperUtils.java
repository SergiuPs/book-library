package de.pislaru.sergiu.booklibrary.utils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelMapperUtils {

    public static <S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return   source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toSet());
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return   source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
