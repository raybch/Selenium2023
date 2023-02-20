package init;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private RemoteWebDriver remoteWebDriver;
    static Map<String, RemoteWebDriver> map = new HashMap<String, RemoteWebDriver>();

    /**
     * Create a WebDriver Instance
     *
     * @throws Exception
     */
    public DriverFactory() throws Exception {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptionsMap = new HashMap<String, String>();
        bstackOptionsMap.put("source", "testng:archetype-setup:v1.5");
        capabilities.setCapability("bstack:options", bstackOptionsMap);
        try {
            remoteWebDriver = new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), capabilities);
            remoteWebDriver.manage().window().maximize();
            setDriver(remoteWebDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * detect the OS on which tests are running
     */

    public static synchronized void setDriver(RemoteWebDriver remote) {
        String id = Thread.currentThread().getName().trim();
        map.put(id, remote);
    }

    public static synchronized RemoteWebDriver getDriver() {
        String id = Thread.currentThread().getName().trim();
        return map.get(id);
    }

    public static synchronized void setDriverFactory(DriverFactory factory) {
        factory = factory;
    }
}