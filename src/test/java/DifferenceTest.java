import com.company.*;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DifferenceTest {
    private Difference differencer;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Difference Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Difference Tests have finished!");

    }

    @Before
    public void SetUp() {
        differencer = new Difference();
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = differencer.of(new Const(1), new Const(2)).calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = -1.0;
        assertEquals("1 - 2 = -1", result, differencer.of(new Const(1), new Const(2)).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnSumType() {
        result = differencer.of(new Const(1), new Const(2)).derivative();
        assertTrue("method must return Difference", result instanceof Difference);
    }

    @Test
    public void DerivativeMethodTest() {
        result = -1.0;
        assertEquals("(3-1*x)` = -1", result, differencer.of(new Const(3), new Linear(1)).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = differencer.of(new Const(1), new Const(2)).toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "(2-1*x)";
        assertEquals("must be (2-1*x)", result, differencer.of(new Const(2), new Linear(1)).toPrettyString(NumberFormat.getInstance()));
    }
}
