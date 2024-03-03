package coffee;

import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@Getter
@Setter
public class PersonController {
    private PersonService personService;
    private ModelMapper modelMapper;

    @PermitAll
    @GetMapping("/string")
    public String getPersonString() {
        return "Returning a plain String to test that there's a response from Coffee-Server";
    }

    @PermitAll
    @GetMapping("/")
    public Mono<ResponseEntity<PersonDto>> getPerson() {
        //Response Mono is a stream where conversion of POJO to JSON is handled automatically
        return personService.getPerson()
                .flatMap(person -> {
                    var personDto = modelMapper.map(person, PersonDto.class);
                    return Mono.just(ResponseEntity.ok(personDto));
                        })
                            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
