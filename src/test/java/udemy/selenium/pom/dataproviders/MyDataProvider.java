package udemy.selenium.pom.dataproviders;

import org.testng.annotations.DataProvider;
import udemy.selenium.pom.objects.Products;
import udemy.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class MyDataProvider {
    @DataProvider(name = "getFeaturedProducts",parallel = true)
    public Object[] getFeaturedProducts() throws IOException {
        return JacksonUtils.deserializeJson("products.json", Products[].class);
    }
}
