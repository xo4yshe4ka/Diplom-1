package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredientGetType {
    protected Ingredient ingredient;

    private IngredientType type;
    private String expectedName;
    private float expectedPrice;

    public TestIngredientGetType(IngredientType type, String expectedName, float expectedPrice) {
        this.type = type;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getIngredient() {
        return new Object[][] {
                {IngredientType.SAUCE, "Sauce spicy-x", 12.65F},
                {IngredientType.FILLING, "Protostomia", 26.78F}
        };
    }

    @Test
    public void testGetType() {
        ingredient = new Ingredient(type, expectedName, expectedPrice);
        IngredientType actualType = ingredient.getType();

        assertEquals(type, actualType);
    }
}
