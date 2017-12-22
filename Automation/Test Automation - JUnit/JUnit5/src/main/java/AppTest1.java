import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AppTest1 {
    @Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        //remainder of test will proceed
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AppTest1::message);
        //remainder of test will be aborted
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }
}