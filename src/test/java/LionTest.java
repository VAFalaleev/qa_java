import org.example.Feline;
import org.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testLionInvalidSexThrowsExceptionWithCorrectMessage() {
        try {
            new Lion("Неизвестный", felineMock);
            fail("Expected exception for invalid sex");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testGetKittensCallsFelineGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", felineMock);

        lion.getKittens();
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(felineMock.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", felineMock);

        int actualKittens = lion.getKittens();
        assertEquals("Lion kittens count should match feline", 5, actualKittens);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", felineMock);

        lion.getFood();
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);

        List<String> actualFood = lion.getFood();
        assertEquals("Lion food should match feline food", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodPropagatesException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Food error"));
        Lion lion = new Lion("Самец", felineMock);

        try {
            lion.getFood();
            fail("Expected exception from getFood");
        } catch (Exception e) {
            assertEquals("Food error", e.getMessage());
        }
    }

    @Test
    public void testLionSingleParameterConstructor() throws Exception {
        Lion lion = new Lion("Самец");
        assertEquals("Should be able to get kittens from single param constructor", 1, lion.getKittens());
    }
}