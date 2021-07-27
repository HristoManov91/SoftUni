package com.example.cardealer.util.impl;

import com.example.cardealer.util.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T fromFile(String filePah, Class<T> clazz) throws JAXBException, FileNotFoundException {
        jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(filePah));
    }

    @Override
    public <T> void writeToFile(String filePath, T entity) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , true);

        marshaller.marshal(entity , new File(filePath));
    }
}
