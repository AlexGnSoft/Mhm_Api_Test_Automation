import config.Utils;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.getLogger;


public abstract class BaseTest {
    private static final Logger log = getLogger();

    private String baseHost;

    public BaseTest() {
        this.baseHost = Utils.getCareSpeakUrl();
    }
}


