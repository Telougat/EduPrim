package com.eduprim;

import com.eduprim.beans.Adulte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Helpers {
    public static boolean userConnected(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Adulte adulte = (Adulte) session.getAttribute("user");
        return adulte != null;
    }

    public static void setSessionUser(HttpServletRequest request, Adulte adulte) {
        HttpSession session = request.getSession();
        session.setAttribute("user", adulte);
    }

    public static Adulte getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Adulte) session.getAttribute("user");
    }

    public static void disconnectUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
