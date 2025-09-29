import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineTests {

 @Test
    public void eatMeatTest() throws Exception {
     Feline feline = new Feline();
     assertEquals(feline.eatMeat(), feline.getFood("Хищник"));
 }

 @Test
    public void getFamilyTest() {
     Feline feline = new Feline();
     assertEquals("Кошачьи", feline.getFamily());

 }

 @Test
    public void getKittensTest() {
     Feline feline = new Feline();
     assertEquals(1, feline.getKittens());
 }

}
