package interfell.vehicle.miles.interceptors;

import org.slf4j.Logger;

import interfell.vehicle.miles.core.ApplicationContext;
import interfell.vehicle.miles.utils.LoggerUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class RequestContextHolder {

    private static final Logger log = LoggerUtils.getLogger(RequestContextHolder.class);
    private static final String NTT_LANG_HEADER = "X-ISP-LANG";
    private static final InheritableThreadLocal<ApplicationContext> applicationContext = new InheritableThreadLocal<>();
    private static final InheritableThreadLocal<HttpServletRequest> request = new InheritableThreadLocal<>();

    protected RequestContextHolder() {
    }

    public static ApplicationContext getApplicationContext() {
        ApplicationContext applicationContext = RequestContextHolder.applicationContext.get();
        if(applicationContext == null) {
            applicationContext = ApplicationContext.initWithDefault();
            log.debug("Thread {}-{}, null ApplicationContext: returning default initialization", Thread.currentThread().getName(), Thread.currentThread().getId());
        }
        return applicationContext;
    }
    public static HttpServletRequest getRequest() {
        return request.get();
    }

    public static String getRequestLanguage() {
        HttpServletRequest req = request.get();
        return req != null ? req.getHeader(NTT_LANG_HEADER) : null;
    }

    public static void setRequest(HttpServletRequest req) {
        Objects.requireNonNull(req, "HttpServletRequest cannot be null");

        if(request.get() != null)
            throw new IllegalStateException("HttpRequest already initialized");

        log.debug(LoggerUtils.formatArchRow("Thread {}-{}, init HttpRequest variable"),
                Thread.currentThread().getName(), Thread.currentThread().getId());

        request.set(req);
    }

    public static void forceSetRequest(HttpServletRequest req) {
        log.debug(LoggerUtils.formatArchRow("Forcing request setting on thread Thread {}-{}"),
                Thread.currentThread().getName(), Thread.currentThread().getId());
        request.set(req);
    }

    public static void clear() {
        try {
            RequestContextHolder.request.remove();
        } catch (Exception t) {
            log.warn(LoggerUtils.formatArchRow("Swallowed error while clearing HttpServletRequest"), t);
        }
    }
}
