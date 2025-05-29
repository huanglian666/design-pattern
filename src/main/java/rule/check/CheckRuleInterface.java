package rule.check;

import java.util.Map;

@FunctionalInterface
public interface CheckRuleInterface {
    void check(Map<String, Object> param);
}
