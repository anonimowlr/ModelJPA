<%-- 
    Document   : novo-calculo
    Created on : 23/11/2018, 11:27:16
    Author     : f5078775
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <script src="<c:url value="resources/js/gsv.js"/>" type="text/javascript"></script>
        <title>Pesquisar cálculo anterior</title>




    </head>
    <body>

        <div class="container">
            <div class=" row">

                <div class="table-responsive">

                    <table id="tabelaGsv" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr >
                                <th >PROTOCOLO</th>
                                <th>NOME_PROCESSO</th>
                                <th>ATIVIDADE</th>
                               
                                <th>DATA_ENTRADA</th>
                                
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista}" var="item">
                                <tr >
                                    <td>${item.protocolo}</td>
                                    <td>${item.processo}</td>
                                    <td>${item.atividade}</td>
                                    
                                    
                                    <td><fmt:formatDate type="date" value="${item.dataEntrada}" pattern="dd/MM/YYY"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>





                </div>

            </div>     
        </div>



        
        


    </body>
</html>
