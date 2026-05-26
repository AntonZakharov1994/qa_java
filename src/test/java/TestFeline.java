import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestFeline {
    private Feline feline;

    @Before
    public void SetUp(){
        feline = new Feline();
    }


    @Test
    public void testEatMeat () throws Exception{
        List<String> list = feline.eatMeat();
        int actual = list.size();
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }
    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }
}
