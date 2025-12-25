package com.scm.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static void removeMessage() {
        try {
            System.out.println("Removing message From Session!!!");
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                    .getSession();
            // he return akrel the requestattribute currently bound with that thread
            session.removeAttribute("message");
        } catch (Exception e) {

            System.out.println("Error in SessionHelper:" + e);
            e.printStackTrace();
        }

    }
}