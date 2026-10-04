import java.util.HashMap;
import java.util.Map;

public class NotifierFactoryManager {

    private static final Map<String, NotifierFactory> map = new HashMap<>();

    static {
        map.put("email", new EmailNotifierFactory());
        map.put("sms", new SMSNotifierFactory());
        map.put("push", new PushNotifierFactory());
    }

    public static NotifierFactory getFactory(String type) {
        return map.get(type.toLowerCase());
    }
}
