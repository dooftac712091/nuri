package ksmart.ks48team01.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("SID");

        if(sessionId != null) {
            String sessionLevel = (String) session.getAttribute("SLEVEL");
            String requestURI = request.getRequestURI();

            if(sessionLevel.equals("2")) {
                if(requestURI.contains("/admin/user")
                    || requestURI.contains("/admin/officer")
                    || requestURI.contains("/admin/store/storeList")) {
                    response.sendRedirect("/admin");
                    return false;
                }
            } else if (sessionLevel.equals("3")) {
                if(requestURI.contains("/admin/adminRegister")) {
                    response.sendRedirect("/");
                    return false;
                }
            } else if (sessionLevel.equals("4")) {
                if(requestURI.contains("/admin")) {
                    response.sendRedirect("/");
                    return false;
                }
            }
            return true;
        }

        response.sendRedirect("/user/auth/login");
        return false;
    }
}
