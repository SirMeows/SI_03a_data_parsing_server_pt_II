import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class PersonController {

    @GetMapping("/")
    String getPerson() {
        return "person information";
    }
}
