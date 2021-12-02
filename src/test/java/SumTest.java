import com.company.Const;
import com.company.Linear;
import com.company.Sum;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SumTest {
    private Sum sumer;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Sum Tests...");
    }

    @AfterClass
    public static void GlobalFinish() {
        System.out.println("Linear Sum have finished!");
    }

    @Before
    public void SetUp() {
        sumer = new Sum();
        result = new Object();
    }

    @After
    public void Finish() {
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType() {
        result = sumer.calculate(1);
        assertTrue("method must return double", result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() {
        result = 1.0 + 2.0;
        assertEquals("1 + 2 = 3", result, sumer.of(new Const(1), new Const(2)).calculate(1));
    }

    @Test
    public void DerivativeMethodReturnSumType() {
        result = sumer.derivative();
        assertTrue("method must return Sum", result instanceof Sum);
    }

    @Test
    public void DerivativeMethodTest() {
        result = 3.0;
        assertEquals("(x + 2*x)` = 3", result, sumer.of(new Linear(1), new Linear(2)).derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType() {
        result = sumer.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String", result instanceof String);
    }

    @Test
    public void ToPrettyStringTest() {
        result = "(1*x+2*x)";
        assertEquals("must be (1*x+2*x)", result, sumer.of(new Linear(1), new Linear(2)).toPrettyString(NumberFormat.getInstance()));
    }
}
