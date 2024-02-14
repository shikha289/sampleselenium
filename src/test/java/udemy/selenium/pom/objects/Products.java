package udemy.selenium.pom.objects;
import udemy.selenium.pom.utils.JacksonUtils;
import java.io.IOException;
public class Products {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private  String name;
    public  Products(){}
    public Products(int id) throws IOException {
        Products []products=JacksonUtils.deserializeJson("products.json",Products[].class);
        for (Products product:products){
            if (product.getId()==id){
                this.id=id;
                this.name=product.getName();
            }
        }
    }
}
