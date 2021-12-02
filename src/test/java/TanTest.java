import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TanTest {
    private Tan tan;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Tan Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Tan Tests have finished!");

    }

    @Before
    public void SetUp() {
        tan = new Tan(new Const(90),1);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = tan.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = Math.tan(90);
        assertEquals("Tan(90) = -1.995", result, tan.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnDivideType() {
        result = tan.derivative();
        assertTrue("method must return Divide", result instanceof Divide);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 0.0;
        assertEquals("(tan(90))` = 0", result, tan.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = tan.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "tg(90)";
        assertEquals("must be tg(90)", result, tan.toPrettyString(NumberFormat.getInstance()));
    }
}
