package coffee;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    private String name;
    private List<String> hobbies;
}
