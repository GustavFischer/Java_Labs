import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DivideTest {
    private Divide divider;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Divide Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Divide Tests have finished!");

    }

    @Before
    public void SetUp() {
        divider = new Divide();
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = divider.of(new Const(1), new Const(2)).calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 0.5;
        assertEquals("1 / 2 = 0.5", result, divider.of(new Const(1), new Const(2)).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnDivideType() {
        result = divider.of(new Const(1), new Const(2)).derivative();
        assertTrue("method must return Divide", result instanceof Divide);
    }

    @Test
    public void DerivativeMethodTest() {
        result = -3.0;
        assertEquals("(3 / x)` = -3", result, divider.of(new Const(3), new Linear(1)).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = divider.of(new Const(1), new Const(2)).toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "2/1*x";
        assertEquals("must be -0.1*x", result, divider.of(new Const(2), new Linear(1)).toPrettyString(NumberFormat.getInstance()));
    }
}
