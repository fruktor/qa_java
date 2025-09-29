import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

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

    @Parameterized.Parameters
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Лев", true},
        };
    }

    @Test
    public void doesHasManeTest() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(lion.doesHaveMane(), hasMane);
        }
        catch (Exception e) {
            System.out.println("Используйте допустимые значения пола животного - самей или самка");
        }
    }

}
