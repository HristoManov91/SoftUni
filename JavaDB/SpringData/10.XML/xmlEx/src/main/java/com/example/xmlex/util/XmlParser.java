package com.example.xmlex.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T writeToFile (String filePath , Class<T> clazz);

    <T> T fromFile(String filePath , T entity);
}
