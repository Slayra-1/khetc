package kh.etc.khetc.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 응답에 관련된 Util
 *
 * @author khko
 **/
public final class ResponseUtils {

    public static final Map<String, String> RESULT_SUCCESS = Collections.unmodifiableMap(new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
            put("result", "true");
        }
    });

    public static final Map<String, String> RESULT_FAILURE = Collections.unmodifiableMap(new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
            put("result", "false");
        }
    });

    public static final Map<String, String> RESULT_WITH_REASON(boolean result, String reason) {
        return Collections.unmodifiableMap(new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;
            {
                put("result", String.valueOf(result));
                put("msg", reason);
            }
        });
    }
}
