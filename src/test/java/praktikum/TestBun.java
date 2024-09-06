package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBun {

    protected Bun bun;
    private String expectedName = "StarBurger";
    private float expectedPrice = 2.45F;
    private static final float DELTA = 0.00F;

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();

        assertEquals(expectedPrice, actualPrice, DELTA);
    }
}
