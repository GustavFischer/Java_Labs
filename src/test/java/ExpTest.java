import com.company.Const;
import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExpTest {
    private Exp exponer;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Exp Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Exp Tests have finished!");

    }

    @Before
    public void SetUp() {
        exponer = new Exp(new Linear(-0.1),2);
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = exponer.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 3*Math.exp(2);
        assertEquals("1 * 2 = 2", result, exponer.of(new Const(2),3).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnMultiplicationType() {
        result = exponer.of(new Const(1), 2).derivative();
        assertTrue("method must return Const", result instanceof Multiplication);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 0.0;
        assertEquals("(3*x)` = 3", result, exponer.of(new Const(3), 2).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = exponer.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "e^(2)";
        assertEquals("must be e^(2)", result, exponer.of(new Const(2), 1).toPrettyString(NumberFormat.getInstance()));
    }
}
