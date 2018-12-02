<%-- 
    Document   : index
    Created on : 19/03/2018, 11:00:52
    Author     : f2253141
--%>
<%@page import="br.com.calculopoupanca.entity.Funcionario"%>
<%@page import="br.com.calculopoupanca.dao.FuncionarioDAO"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    
  boolean precisaAutenticar = false;
    if (session.getAttribute("usuarioLogado") == null) {
        if (request.getParameter("ibm-nativeid") == null) {
            precisaAutenticar = true;
        } else {
            //session.setAttribute("usuarioLogado", new FuncionarioDAO().getFuncionario(request.getParameter("cd-idgl-usu")));
            session.setAttribute("usuarioLogado", new FuncionarioDAO().getFuncionario(request.getParameter("ibm-nativeid"),request.getParameter("cd-eqp")));

            if (session.getAttribute("usuarioLogado") != null) {
                String uri = request.getScheme() + "://"
                        + request.getServerName()
                        + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                        + request.getRequestURI()
                        + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
                response.sendRedirect("http://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri + "home");

            }
        }
    } else {
        String uri = request.getScheme() + "://"
                + request.getServerName()
                + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                + request.getRequestURI()
                + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
        response.sendRedirect("http://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri + "home");

    }

    if (precisaAutenticar) {
        String uri = request.getScheme() + "://"
                + request.getServerName()
                + ("http".equals(request.getScheme()) && request.getServerPort() == 80 || "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                + request.getRequestURI()
                + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
        response.sendRedirect("http://cenopservicoscwb.intranet.bb.com.br/_tools/loginPortal.php?urlRetorno=" + uri);
    }




%>

<p>Aguarde redirecionando.....</p>