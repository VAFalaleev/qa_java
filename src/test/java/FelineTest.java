import org.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeatReturnsPredatorFood() {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Feline should eat meat", expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        assertEquals("Feline family should be 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParametersReturnsOne() {
        Feline feline = new Feline();
        assertEquals("Default kittens count should be 1", 1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameterReturnsSameValue() {
        Feline feline = new Feline();
        assertEquals("Kittens count should match input", 5, feline.getKittens(5));
    }
}