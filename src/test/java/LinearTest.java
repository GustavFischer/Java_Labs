import com.company.Const;
import com.company.Linear;
import org.junit.*;

import java.text.NumberFormat;

import static org.junit.Assert.*;

public class LinearTest {
    private Linear linear;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Linear Tests...");
    }

    @AfterClass
    public static void GlobalFinish(){
        System.out.println("Linear Tests have finished!");
    }

    @Before
    public void SetUp() {
        linear = new Linear(-0.1);
        result = new Object();
    }

    @After
    public void Finish(){
        System.out.println("Test method has finished.");
    }

    @Test
    public void CalculateMethodReturnDoubleType(){
        result = Linear.X.calculate(1);
        assertTrue("method must return double",result instanceof Double);
    }

    @Test
    public void CalculateMethodTest() throws Exception{
        result = linear.calculate(1);
        assertEquals("1 * (-0.1) = -0.1",result,Linear.X.calculate(1));
    }

    @Test
    public void DerivativeMethodReturnConstType(){
        result = Linear.X.derivative();
        assertTrue("method must return Const",result instanceof Const);
    }

    @Test
    public void DerivativeMethodTest(){
        result = linear.derivative().calculate(1);
        assertEquals("x` = -0.1",result,Linear.X.derivative().calculate(1));
    }

    @Test
    public void ToPrettyStringReturnStringType(){
        result = Linear.X.toPrettyString(NumberFormat.getInstance());
        assertTrue("method must return String",result instanceof String);
    }

    @Test
    public void ToPrettyStringTest(){
        result = linear.toPrettyString(NumberFormat.getInstance());
        assertEquals("must be -0.1*x",result,new Linear(-0.1).toPrettyString(NumberFormat.getInstance()));
    }


}
