import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SinTest {
    private Sin sin;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Sin Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Sin Tests have finished!");

    }

    @Before
    public void SetUp() {
        sin = new Sin(new Const(90),1);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = sin.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = Math.sin(90);
        assertEquals("sin(90) = 1", result, sin.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = sin.derivative();
        assertTrue("method must return Multiplication", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = -0.0;
        assertEquals("(sin(90))` = 0", result, sin.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = sin.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "sin(90)";
        assertEquals("must be sin(90)", result, sin.toPrettyString(NumberFormat.getInstance()));
    }
}
