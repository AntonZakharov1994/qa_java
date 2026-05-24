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
    public void getKittens() throws Exception {
        // Настраиваем мок: задаём ожидаемое количество котят
        Mockito.when(feline.getKittens()).thenReturn(3);

        // Создаём льва-самца и проверяем количество котят
        Lion maleLion = new Lion(MALE, feline);
        assertEquals(3, maleLion.getKittens());
        assertTrue(maleLion.doesHaveMane()); // Самцы имеют гриву

        // Создаём львицу и проверяем количество котят
        Lion femaleLion = new Lion(FEMALE, feline);
        assertEquals(3, femaleLion.getKittens());
        assertFalse(femaleLion.doesHaveMane()); // Самки не имеют гривы
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(MALE, feline);
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(MALE, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionByCreateLionWithInvalidGender() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(exceptionMessage);
        new Lion("НекорректныйПол", feline);
    }
}
