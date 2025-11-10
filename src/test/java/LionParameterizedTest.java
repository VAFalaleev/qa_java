import org.example.Feline;
import org.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline felineMock;

    private final String sex;
    private final Boolean expectedHasMane;
    private final boolean shouldTestException;

    public LionParameterizedTest(String sex, Boolean expectedHasMane, boolean shouldTestException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.shouldTestException = shouldTestException;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Sex: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {"Мужской", null, true},
                {"Женский", null, true}
        });
    }

    @Test
    public void testLionSex() throws Exception {
        if (shouldTestException) {
            testInvalidSexThrowsException();
        } else {
            testValidSexHasCorrectMane();
        }
    }

    private void testValidSexHasCorrectMane() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals("Lion with sex '" + sex + "' should have mane = " + expectedHasMane,
                expectedHasMane, lion.doesHaveMane());
    }

    private void testInvalidSexThrowsException() {
        try {
            new Lion(sex, felineMock);
            fail("Expected exception for invalid sex: '" + sex + "'");
        } catch (Exception e) {
            assertEquals("Exception message should be correct for invalid sex: '" + sex + "'",
                    "Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}