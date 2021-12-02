import com.company.Const;
import com.company.Linear;
import com.company.Multiplication;
import com.company.Sum;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultiplicationTest {
    private Multiplication multier;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Multiplication Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Multiplication Tests have finished!");

    }

    @Before
    public void SetUp() {
        multier = new Multiplication();
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = multier.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 2.0;
        assertEquals("1 * 2 = 2", result, multier.of(new Const(1), new Const(2)).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnSumType() {
        result = multier.of(new Const(1), new Const(2)).derivative();
        assertTrue("method must return Const", result instanceof Sum);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 3.0;
        assertEquals("(3*x)` = 3", result, multier.of(new Const(3), new Linear(1)).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = multier.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "(2*1*x)";
        assertEquals("must be (2*1*x)", result, multier.of(new Const(2), new Linear(1)).toPrettyString(NumberFormat.getInstance()));
    }
}
