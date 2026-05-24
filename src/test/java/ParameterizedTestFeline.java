import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class ParameterizedTestFeline {

    private final int kittensCount;
    private final int expected;

    public ParameterizedTestFeline(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index} : getKittens({0}) = {1}")
    public static Object[][] getKittensByCountData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Test
    public void getKittensByCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);

        assertEquals(expected, actual);
    }
}

