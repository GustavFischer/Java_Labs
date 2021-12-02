import com.company.Sum;
import org.junit.*;

public class SumTest {
    private Sum sumer;
    private Object result;

    @BeforeClass
    public static void GlobalSetUp() {
        System.out.println("Starting Sum Tests...");
    }

    @AfterClass
    public static void GlobalFinish(){
        System.out.println("Linear Sum have finished!");
    }

    @Before
    public void SetUp() {
        sumer = new Sum();
        result = new Object();
    }

    @After
    public void Finish(){
        System.out.println("Test method has finished.");
    }


}
