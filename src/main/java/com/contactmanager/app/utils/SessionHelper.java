package com.contactmanager.app.utils;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Component
@Slf4j
public class SessionHelper {

    public void removeMessageFromSession(){
        try{
            log.info("Removing message from session");
            HttpSession session = ((ServletRequestAttributes)
                    Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
            session.removeAttribute("message");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
