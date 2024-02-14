package udemy.selenium.pom.api.actions;

import udemy.selenium.pom.objects.User;
import udemy.selenium.pom.utils.FakerUtils;

public class DummyClass {
    public static void main(String[] args) {
      /*  String username="demouser"+new FakerUtils().generateRandomNumber();
        User user=new User().setUsername(username).setPassword("demopwd").setEmail(username+"@askomdch.com");
        SignUpApi signUpApi=new SignUpApi();
        System.out.println(signUpApi.register(user));
        System.out.println(signUpApi.getCookies());*/
       /* CartApi cartApi=new CartApi();
        cartApi.addToCart(1215,1);
        System.out.println(cartApi.getCookies());*/
        String username="demouser"+new FakerUtils().generateRandomNumber();
        User user=new User().setUsername(username).setPassword("demopwd").setEmail(username+"@askomdch.com");
        SignUpApi signUpApi=new SignUpApi();
      signUpApi.register(user);
      System.out.println("register cookie"+signUpApi.getCookies());
      CartApi cartApi=new CartApi(signUpApi.getCookies());
      cartApi.addToCart(1215,1);
      System.out.println("cart cookies"+cartApi.getCookies());
    }
}
