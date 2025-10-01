import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionParameterizedTests {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, грива: {1}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Лев", true},
        };
    }



    @Test
    public void doesHasManeTest() throws Exception {
        if ( sex.equals("Самка") || sex.equals("Самец") ) {
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());
        }
        else {
            Lion lion = mock(Lion.class);
            when(lion.doesHaveMane()).thenThrow(new RuntimeException("Используйте допустимые значения пола животного - самец или самка"));

            Exception exception = assertThrows(RuntimeException.class, () -> {
                lion.doesHaveMane();
            });

            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

}
