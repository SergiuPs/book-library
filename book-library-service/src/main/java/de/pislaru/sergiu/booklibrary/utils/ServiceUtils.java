package de.pislaru.sergiu.booklibrary.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

public final class ServiceUtils {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    private ServiceUtils() {

    }

    @SuppressWarnings("unchecked")
    public static <T> T applyPatchToEntity(JsonPatch patch, T targetEntity) throws JsonPatchException, JsonProcessingException {
        JsonNode node = objectMapper.convertValue(targetEntity, JsonNode.class);
        JsonNode patched = patch.apply(node);

        return objectMapper.treeToValue(patched, (Class<T>) targetEntity.getClass());
    }

}
