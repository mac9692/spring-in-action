package tacos.dto;

import tacos.enums.IngredientType;

public record Ingredient(String id, String name, IngredientType type) {}
