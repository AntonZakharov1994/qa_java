
import java.util.List;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestAnimal {
    private final String animalKind;
    private final List<String> expected;

    public ParameterizedTestAnimal(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index} : getFood({0}) = {1}")
    public static Object[][] getFoodData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        List<String> list = animal.getFood(animalKind);
        int actual = list.size();

        assertEquals(expected.size(), actual);
    }
}