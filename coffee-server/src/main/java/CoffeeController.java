import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CoffeeController {

    @GetMapping("/")
    String getPersonJSON() {
        return "person information";
    }
}
