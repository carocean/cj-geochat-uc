package cj.geochat.open.uc.web.rest;

import cj.geochat.open.uc.IReadFully;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IAppEntrypointRestfull extends IReadFully {
   void entrypoint(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
