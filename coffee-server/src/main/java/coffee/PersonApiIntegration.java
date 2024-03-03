package coffee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Getter
@Setter
@Service
public class PersonApiIntegration {
    private final WebClient webClient;
    private final String serverBUri = "/";

    public Mono<Person> getPerson() {
        return this.webClient.get()
                .uri(serverBUri)
                .retrieve()
                .bodyToMono(Person.class);
    }
}
