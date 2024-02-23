import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String rootDirectory = "G:/My Drive/KEA/SI_Code/SI_03a_data_parsing_server_pt_II/resources";
        DataParser dataParser = new DataParser();
        try {
            dataParser.parseXML(rootDirectory + "/me.xml");
            dataParser.parseJSON(rootDirectory + "/me.json");
            dataParser.parseYAML(rootDirectory + "/me.yaml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
