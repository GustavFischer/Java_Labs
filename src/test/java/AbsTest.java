import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbsTest {
    private Abs abs;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Abs Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Abs Tests have finished!");

    }

    @Before
    public void SetUp() {
        abs = new Abs(new Linear(-0.1));
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = abs.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 2.0;
        assertEquals("|-2| = 2", result, abs.of(new Const(-2)).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = abs.of(new Const(1)).derivative();
        assertTrue("method must return Multiplication", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 3.0;
        assertEquals("(2*e^3)` = 0", result, abs.of(new Linear(-3)).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = abs.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "|2|";
        assertEquals("must be |2|", result, abs.of(new Const(2)).toPrettyString(NumberFormat.getInstance()));
    }
}
