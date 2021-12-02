import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LnTest {
    private Ln ln;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Ln Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Ln Tests have finished!");

    }

    @Before
    public void SetUp() {
        ln = new Ln(new Const(90),1);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = ln.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = Math.log10(90);
        assertEquals("Ln(90) = 4.49", result, ln.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = ln.derivative();
        assertTrue("method must return Multiplication", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 0.0;
        assertEquals("(ln(90))` = 0", result, ln.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = ln.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "ln|90|";
        assertEquals("must be Ln(90)", result, ln.toPrettyString(NumberFormat.getInstance()));
    }
}
