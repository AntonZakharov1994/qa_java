import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class TestCat {
@Mock
    private Feline felineMock;
    private Cat cat;
@Before
public void setUp(){
    cat = new Cat(felineMock);
}

@Test
    public void TestGetSound(){
    String sound = cat.getSound();
    assertEquals("Метод должен возвращать  'Мяу'", "Мяу", sound);
}
    @Test
    public void getFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }
}



