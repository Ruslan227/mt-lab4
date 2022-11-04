package control.table;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface GrammarDataI {
    Object reduceFromRightPart(Object rp);
    Map<String, Function<Map<String, List<Object>>, Object>> getRightPartConstructor();

}
