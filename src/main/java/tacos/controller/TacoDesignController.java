package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.dto.Ingredient;
import tacos.dto.Taco;
import tacos.enums.IngredientType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("design")
@Slf4j
public class TacoDesignController {

    @GetMapping
    public String getDesignForm(Model model) {
        List<Ingredient> ingredientList = List.of(
                new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
                );

        IngredientType[] types = IngredientType.values();
        Arrays.stream(types)
                .forEach(type -> model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList, type)));

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredientList, IngredientType type) {
        return ingredientList.stream().filter(x -> x.type().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Taco request) {
        log.info("Prrrrrrrocessing Design : " + request);

        return "redirect:/orders/current";
    }
}
