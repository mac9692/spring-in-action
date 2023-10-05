package tacos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Taco {
    private String name;
    private List<String> ingredients;
    private Long id;
    private Date createdAt;
}
