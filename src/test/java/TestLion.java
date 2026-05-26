import java.util.List;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.rules.ExpectedException;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    private Feline feline;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getKittens_forMaleLion_returnsCorrectCount() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion maleLion = new Lion(MALE, feline);
        assertEquals(3, maleLion.getKittens());
    }

    @Test
    public void doesHaveMane_forMaleLion_returnsTrue() throws Exception {

        Lion maleLion = new Lion(MALE, feline);
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void getKittens_forFemaleLion_returnsCorrectCount() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion femaleLion = new Lion(FEMALE, feline);
        assertEquals(3, femaleLion.getKittens());
    }

    @Test
    public void doesHaveMane_forFemaleLion_returnsFalse() throws Exception {

        Lion femaleLion = new Lion(FEMALE, feline);
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void getFood_returnsCorrectDiet() throws Exception {
        Lion lion = new Lion(MALE, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionByCreateLionWithInvalidGender_throwsException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(exceptionMessage);
        new Lion("НекорректныйПол", feline);
    }
}

