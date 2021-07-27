package com.example.cardealer.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePah , Class<T> clazz) throws JAXBException, FileNotFoundException;

    <T> void writeToFile (String filePath , T entity) throws JAXBException;
}
