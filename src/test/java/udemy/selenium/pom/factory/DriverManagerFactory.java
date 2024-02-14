package udemy.selenium.pom.factory;

import udemy.selenium.pom.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType driverType){
        switch (driverType){
            case CHROME->{
                return new ChromeDriverManager();
            }
            case FIREFOX->{
                return new FireFoxDriverManager();
            }
            default->throw new IllegalStateException("unexpected value:"+driverType);

        }
    }
}
