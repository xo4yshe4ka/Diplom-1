package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredient {
    protected Ingredient ingredient;

    private IngredientType type = IngredientType.FILLING;
    private String expectedName = "Соус традиционный галактический";
    private float expectedPrice = 23.54F;
    private static final float DELTA = 0.00F;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, expectedName, expectedPrice);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice, DELTA);
    }

    @Test
    public void testGetName() {
        String actualName = ingredient.getName();

        assertEquals(expectedName, actualName);
    }
}
