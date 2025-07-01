package com.tests.Common;

    import com.Railway.constant.Constants;
    import com.Railway.driver.DriverManager;
    import com.Railway.utilities.TestDataLoader;
    import com.google.gson.JsonArray;
    import com.google.gson.JsonElement;

    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.DataProvider;

    public class TestBase {

        @BeforeMethod
        public  void BeforeTest(){
            DriverManager.createDriver();
            DriverManager.getDriver().get(Constants.BASE_URL);

        };

        @AfterMethod
        public  void AfterTest(){
            DriverManager.quitDriver();
        }

        @DataProvider(name = "TestDataProvider")
        public Object[][] provideTestData(java.lang.reflect.Method method) {
            String testName = method.getName();  // Lấy tên method test
            String className = method.getDeclaringClass().getSimpleName(); // Lấy tên class như "TC01", "TC14"
            
            JsonElement element = TestDataLoader.getTestData(className); // Sử dụng class name thay vì hardcode
            if (element.isJsonObject()) {
                return new Object[][] { { element.getAsJsonObject() } };
            } else if (element.isJsonArray()) {
                JsonArray array = element.getAsJsonArray();
                Object[][] data = new Object[array.size()][1];
                for (int i = 0; i < array.size(); i++) {
                    data[i][0] = array.get(i).getAsJsonObject();
                }
                return data;
            } else {
                throw new IllegalArgumentException("Unsupported data format for test: " + className);
            }
        }
    }