package interfell.vehicle.miles.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;

import interfell.vehicle.miles.utils.LoggerUtils;

public class ErrorContext {

    Logger logger = LoggerUtils.getLogger(ErrorContext.class);

    private final String projectId;

    private final ConcurrentMap<String, Map<String, Object>> errorMap;

    public ErrorContext(String projectId) {
        this.projectId = projectId;
        this.errorMap = new ConcurrentHashMap<>();
    }

    public String getProjectId() {
        return projectId;
    }

    public Set<String> getErrorKeys() {
        return new HashSet<>(this.errorMap.keySet());
    }
    
    public Map<String, Map<String, Object>> getErrorMap() {
        return new HashMap<>(this.errorMap);
    }

    public void addErrorKey(String errorKey) {
        logger.info("adding errorKey: {}", errorKey);
        this.errorMap.put(toLowerCase(errorKey), Collections.emptyMap());
    }
    
    public void addErrorKey(String errorKey, Map<String, Object> messageArgs) {
        logger.debug("adding errorKey: {} with messageArgs: {}", errorKey, messageArgs);
        this.errorMap.put(toLowerCase(errorKey), Objects.requireNonNull(messageArgs, "Message arguments are required"));
    }

    public void addErrorKeys(Collection<String> errorKeys) {
        Objects.requireNonNull(errorKeys, "null error keys");

        this.errorMap.putAll(errorKeys.stream()
                .filter(Objects::nonNull)
                .peek(k -> logger.info("adding errorKey: {}", k))
                .map(ErrorContext::toLowerCase)
                .collect(Collectors.toMap(Function.identity(), k -> Collections.emptyMap())));
    }
    
    public void removeErrorKey(String errorKey) {
        logger.info("removing errorKey: {}", errorKey);

        this.errorMap.remove(toLowerCase(errorKey));
    }

    public void removeErrorKeys(Collection<String> errorKeys) {
        errorKeys.stream()
                .filter(Objects::nonNull)
                .map(ErrorContext::toLowerCase)
                .peek(k -> logger.info("removing errorKey: {}", k))
                .forEach(this.errorMap::remove);
    }

    private static String toLowerCase(String errorKey) {
        return Objects.requireNonNull(errorKey, "null errorKey").toLowerCase();
    }

}
