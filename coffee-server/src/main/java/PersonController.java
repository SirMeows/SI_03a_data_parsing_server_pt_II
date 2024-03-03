import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class PersonController {
    private PersonService personService;
    private ModelMapper modelMapper;

    @GetMapping("/")
    public Mono<ResponseEntity<PersonDto>> getPerson() {
        //Get Mono<Entity> from service
        //Check that Mono contains an object with correct information
        //Response Mono is a stream where conversion of POJO to JSON is handled automatically
        return personService.getPerson()
                .flatMap(person -> {
                    var personDto = modelMapper.map(person, PersonDto.class);
                    return Mono.just(ResponseEntity.ok(personDto));
                        })
                            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
