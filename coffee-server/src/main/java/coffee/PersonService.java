package coffee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonApiIntegration personApiIntegration;
    private DataParser dataParser;

    public Mono<Person> getPerson() {
        return personApiIntegration.getPerson();
    }

    public Mono<Person> getPersonFromFile(String fileType) {
        return dataParser.parseFile(fileType);
    }
}
