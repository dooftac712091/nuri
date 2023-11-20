package ksmart.ks48team01.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.StringJoiner;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Set<String> parameterKeySet = request.getParameterMap().keySet();

        StringJoiner param = new StringJoiner(", ");

        for(String key : parameterKeySet) {
            param.add(key + ": " + request.getParameter(key));
        }

        log.info("ACCESS INFO====================================START");
        log.info("PORT ::: {}", request.getLocalPort());
        log.info("ServerName ::: {}", request.getServerName());
        log.info("Method ::: {}", request.getMethod());
        log.info("URI ::: {}", request.getRequestURI());
        log.info("Client IP ::: {}", request.getRemoteAddr());
        log.info("Parameter ::: {}", param);
        log.info("ACCESS INFO====================================END");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
        throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
