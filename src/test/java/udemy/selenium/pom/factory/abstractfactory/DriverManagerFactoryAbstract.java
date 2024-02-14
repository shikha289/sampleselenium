package udemy.selenium.pom.factory.abstractfactory;

import udemy.selenium.pom.constants.DriverType;

public class DriverManagerFactoryAbstract {
    public static DriverManagerAbstract getManager(DriverType driverType) {
        switch (driverType) {
            case CHROME -> {
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX -> {
                return new FireFoxDriverManagerAbstract();
            }
            default -> throw new IllegalStateException("unexpected value:" + driverType);
        }
    }
}