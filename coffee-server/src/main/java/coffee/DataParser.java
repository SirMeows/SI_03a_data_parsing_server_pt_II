package coffee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.IOException;

public class DataParser {
    private final ObjectMapper mapper = new ObjectMapper();

    public Person parseXML(String filePath) throws IOException {
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[]{"*"});
        xstream.processAnnotations(Person.class);

        var person = (Person) xstream.fromXML(new File(filePath));
        System.out.println("coffee.Person object from XML:"+person);
        return person;
    }

    public Person parseJSON(String filePath) throws IOException {
        var person = mapper.readValue(new File(filePath), Person.class);
        System.out.println("coffee.Person object from JSON:"+person);
        return person;
    }

    public Person parseYAML(String filepath) throws IOException {
        var person = mapper.readValue(new File(filepath), Person.class);
        System.out.println("coffee.Person object from YAML:"+person);
        return person;
    }

    public void parseCSV(String filepath) throws IOException {


        //System.out.println("coffee.Person object from CSV:"+person);
    }
}