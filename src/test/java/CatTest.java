import org.example.Cat;
import org.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(felineMock);
        assertEquals("Cat sound should be 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodCallsEatMeat() {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();

        assertEquals("Cat food should match feline food",
                List.of("Животные", "Птицы", "Рыба"),
                actualFood);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodPropagatesException() {
        when(felineMock.eatMeat()).thenThrow(new Exception("Food error"));

        Cat cat = new Cat(felineMock);
        cat.getFood();
    }
}