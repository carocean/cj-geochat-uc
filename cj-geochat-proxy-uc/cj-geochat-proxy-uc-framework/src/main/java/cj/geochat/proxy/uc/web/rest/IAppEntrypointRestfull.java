package cj.geochat.proxy.uc.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface IAppEntrypointRestfull {
    Map<String, Object> entrypoint(HttpServletRequest request, HttpServletResponse response);
}
