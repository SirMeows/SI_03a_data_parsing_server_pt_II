import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
//Connect to the Snake-Server and get person information as JSON
public class PersonApiIntegration {
    private final WebClient webClient;

    public Mono<Person> getPerson() {
        return this.webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(Person.class);
    }
}
