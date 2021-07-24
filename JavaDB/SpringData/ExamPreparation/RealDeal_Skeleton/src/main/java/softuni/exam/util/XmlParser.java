package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePath , Class<T> clazz) throws JAXBException, FileNotFoundException;
}
