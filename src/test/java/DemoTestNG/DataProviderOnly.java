package DemoTestNG;

import org.testng.annotations.DataProvider;

public class DataProviderOnly {

    @DataProvider(name = "Input_Provider")
    public static Object[][] inputDataProvider() {
        Object[][] data = new Object[2][3];
        data[0][0] = "joe";          data[0][1] = "joe@gmail.com";        data[0][2] = 1;
        data[1][0] = "jane";        data[1][1] = "jane@gmail.com";        data[1][2] = 2;
        return data;
    }
}
