package com.cur.apps.web.filter;


import com.cur.apps.model.v1.LogRecord;
import com.cur.apps.model.v1.factory.LogRecordFactory;
import com.cur.apps.repository.TimeRepository;
import com.cur.apps.service.AuditService;
import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class CurServerAuditFilter extends OncePerRequestFilter implements Ordered {


    @Autowired
    private LogRecordFactory logRecordFactory;

    @Autowired
    private AuditService auditService;

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 100;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        filterChain.doFilter(wrappedRequest, response);
        int status = response.getStatus();
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

        LogRecord logRecord = logRecordFactory.createLogRecord(timeRepository.getCurrentApplicationDate(),
                request.getMethod(),
                request.getRequestURL().toString(),
                getBody(wrappedRequest),
                request.getRemoteAddr(),
                MoreObjects.firstNonNull(getMessageIfExists(exception), "Success completed with: "
                        + String.valueOf(response.getStatus())),
                HttpStatus.valueOf(status).name());

        auditService.addLogRecord(logRecord);

    }


    private String getMessageIfExists(Throwable ex) {
        if (ex != null) {
            return ex.getMessage();
        }
        return null;
    }

    private String getBody(ContentCachingRequestWrapper request) throws UnsupportedEncodingException {
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                return new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
            }
        }
        return "{\"error\":\"Can not load \"}";
    }


}