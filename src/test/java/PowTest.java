import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PowTest {
    private Pow power;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Pow Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Pow Tests have finished!");

    }

    @Before
    public void SetUp() {
        power = new Pow(2,new Linear(2),1);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = power.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 4.0;
        assertEquals("2^2 = 4", result, power.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = power.derivative();
        assertTrue("method must return Multiplication", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 8.0;
        assertEquals("(2*x^2)` = 8", result, power.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = power.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "(2*x)^2";
        assertEquals("must be (2*x)^2", result, power.toPrettyString(NumberFormat.getInstance()));
    }
}
