package coffee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

@Service
@NoArgsConstructor
public class DataParser {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String filePath = "resources/"; // G:\My Drive\KEA\SI_Code\SI_03a_data_parsing_server_pt_II\resources
    private final String fileName = "me";

    private static boolean isXML(String fileType) {
        return fileType.equalsIgnoreCase(FileType.XML.getName());
    }

    private static boolean isYAML(String fileType) {
        return fileType.equalsIgnoreCase(FileType.YAML.getName());
    }

    private static boolean isJSON(String fileType) {
        return fileType.equalsIgnoreCase(FileType.JSON.getName());
    }

    public Mono<Person> parseFile(String fileType) {
        var fullFilePath = filePath + fileName + "." + fileType.toLowerCase();
        System.out.println("calling the parseFile(String fileType) method from DataParser util class. fullFilePath=" + fullFilePath);

        return Mono.fromCallable(() -> {
            return parseXML(fullFilePath);
//            if (isXML(fileType)) {
//                return parseXML(fullFilePath);
//            } else if (isJSON(fileType)) {
//                return parseJSON(fullFilePath);
//            } else if (isYAML(fileType)) {
//                return parseYAML(fileType);
//            } else {
//                throw new IllegalArgumentException("unsupported file type:" + fileType);
//            }
        });
    }


    private Person parseXML(String filePath) throws IOException {
        XStream xstream = new XStream();
        xstream.allowTypes(new Class[]{Person.class});
        xstream.allowTypesByWildcard(new String[]{"*"});
        xstream.processAnnotations(Person.class);

        var person = (Person) xstream.fromXML(new File(filePath));
        System.out.println("coffee.Person object from XML:"+person);
        return person;
    }

    private Person parseJSON(String filePath) throws IOException {
        var person = mapper.readValue(new File(filePath), Person.class);
        System.out.println("coffee.Person object from JSON:"+person);
        return person;
    }

    private Person parseYAML(String filepath) throws IOException {
        var person = mapper.readValue(new File(filepath), Person.class);
        System.out.println("coffee.Person object from YAML:"+person);
        return person;
    }

    private Person parseCSV(String filepath) throws IOException {
        //System.out.println("coffee.Person object from CSV:"+person);
        return null;
    }
}