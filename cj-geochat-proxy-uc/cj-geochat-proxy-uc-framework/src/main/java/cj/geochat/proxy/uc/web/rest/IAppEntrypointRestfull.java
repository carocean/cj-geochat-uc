package cj.geochat.proxy.uc.web.rest;

import cj.geochat.proxy.uc.IReadFully;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface IAppEntrypointRestfull extends IReadFully {
   void entrypoint(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
