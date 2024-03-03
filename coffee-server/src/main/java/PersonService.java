import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

//The service layer would in more complicated cases connect to other services
//Here it just passes on the Mono<Entity>
@Service
@Getter
@Setter
public class PersonService {
    private PersonApiIntegration personApiIntegration;

    public Mono<Person> getPerson() {
        return personApiIntegration.getPerson();
    }
}
