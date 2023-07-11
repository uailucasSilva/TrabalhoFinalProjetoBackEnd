package com.trabalhoFinal.trabalhoFinal.utils.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class XmlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public XmlJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    protected XmlJackson2HttpMessageConverter(ObjectMapper objectMapper, MediaType supportedMediaType) {
        super(objectMapper, supportedMediaType);
    }

    protected XmlJackson2HttpMessageConverter(ObjectMapper objectMapper, MediaType... supportedMediaTypes) {
        super(objectMapper, supportedMediaTypes);
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        ObjectMapper xmlMapper = getObjectMapper();
        try {
            return xmlMapper.readValue(inputMessage.getBody(), clazz);
        } catch (Exception ex) {
            throw new HttpMessageNotReadableException("Could not read XML: " + ex.getMessage(), ex);
        }
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        ObjectMapper xmlMapper = getObjectMapper();
        try {
            String xml = xmlMapper.writeValueAsString(object);
            byte[] bytes = xml.getBytes(StandardCharsets.UTF_8);
            outputMessage.getBody().write(bytes);
        } catch (Exception ex) {
            throw new HttpMessageNotWritableException("Could not write XML: " + ex.getMessage(), ex);
        }
    }
}