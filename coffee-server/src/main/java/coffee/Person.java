package coffee;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@XStreamAlias("Person")
public class Person {

    private String name;

    @XStreamImplicit(itemFieldName = "hobby")
    private List<String> hobbies;
}
