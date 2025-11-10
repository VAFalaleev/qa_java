import org.example.Animal;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void testGetFoodForPredatorReturnsCorrectList() throws Exception {
        Animal animal = new Animal() {
            @Override
            public List<String> eatMeat() {
                return getFood("Хищник");
            }

            @Override
            public String getFamily() {
                return "Test Family";
            }
        };

        List<String> food = animal.eatMeat();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Predator should return correct food list", expectedFood, food);
    }

    @Test
    public void testGetFoodForHerbivoreReturnsCorrectList() throws Exception {
        Animal animal = new Animal() {
            @Override
            public List<String> eatMeat() {
                return getFood("Травоядное");
            }

            @Override
            public String getFamily() {
                return "Test Family";
            }
        };

        List<String> food = animal.eatMeat();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals("Herbivore should return correct food list", expectedFood, food);
    }

    @Test
    public void testGetFoodForUnknownTypeReturnsEmptyList() throws Exception {
        Animal animal = new Animal() {
            @Override
            public List<String> eatMeat() {
                return getFood("Неизвестный");
            }

            @Override
            public String getFamily() {
                return "Test Family";
            }
        };

        List<String> food = animal.eatMeat();
        List<String> expectedFood = List.of();
        assertEquals("Unknown animal type should return empty list", expectedFood, food);
    }
}