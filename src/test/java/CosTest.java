import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CosTest {
    private Cos cos;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Cos Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Cos Tests have finished!");

    }

    @Before
    public void SetUp() {
        cos = new Cos(new Const(90),1);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = cos.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = Math.cos(90);
        assertEquals("cos(90) = 0", result, cos.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = cos.derivative();
        assertTrue("method must return Multiplication", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = -0.0;
        assertEquals("(cos(90))` = 0", result, cos.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = cos.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "cos(90)";
        assertEquals("must be cos(90)", result, cos.toPrettyString(NumberFormat.getInstance()));
    }
}
