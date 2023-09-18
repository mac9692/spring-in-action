package tacos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Taco {
    private String name;
    private List<String> ingredients;
}
