package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;

    @Spy
    Burger burger;

    @Mock
    Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBun() {
        bun = mock(Bun.class);
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        ingredient1 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        int actualSizeListIngredients = burger.ingredients.size();

        assertTrue(burger.ingredients.contains(ingredient1));
        assertEquals(1, actualSizeListIngredients);
    }

    @Test
    public void testRemoveIngredient() {
        ingredient1 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        int index = burger.ingredients.size() - 1;
        burger.removeIngredient(index);
        int actualSizeListIngredients = burger.ingredients.size();

        assertFalse(burger.ingredients.contains(ingredient1));
        assertEquals(0, actualSizeListIngredients);
    }

    @Test
    public void testMoveIngredient() {
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);
        ingredient3 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(1, 0);

        List<Ingredient> actualIngredients = burger.ingredients;

        assertEquals(ingredient1, actualIngredients.get(1));
        assertEquals(ingredient2, actualIngredients.get(0));
        assertEquals(ingredient3, actualIngredients.get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(20F);

        when(ingredient1.getPrice()).thenReturn(23F);

        when(ingredient2.getPrice()).thenReturn(48F);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = 20F * 2 + 23F + 48F;

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0F);
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Краторная булка N-200i");
        when(bun.getPrice()).thenReturn(15F);
        burger.setBuns(bun);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Соус Spicy-X");

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Meat");

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        when(burger.getPrice()).thenReturn(100F);

        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n" +
                "= sauce Соус Spicy-X =\r\n" +
                "= filling Meat =\r\n" +
                "(==== Краторная булка N-200i ====)\r\n" +
                "\r\nPrice: 130,000000\r\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}
