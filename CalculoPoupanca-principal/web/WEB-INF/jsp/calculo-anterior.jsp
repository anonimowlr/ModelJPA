<%-- 
    Document   : novo-calculo
    Created on : 23/11/2018, 11:27:16
    Author     : f5078775
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <script src="<c:url value="resources/js/calculoAnterior.js"/>" type="text/javascript"></script>
        <title>Pesquisar cálculo anterior</title>




    </head>
    <body>
        
       

        <div class="container">
            <div class=" row">

                <div class="table-responsive">

                    <table id="tabelaCalculo" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr >
                                <th >codigo</th>
                                <th>saldo base</th>
                                <th>correção</th>
                                <th>diferenca</th>
                                <th>valor atual</th>
                                <th>meses</th>
                                <th>funcionario da sessao</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lista}" var="item">
                                <tr >
                                    <td>${item.codigo}</td>
                                    <td>${item.nome}</td>
                                    <td>${item.endereco}</td>
                                    <td>${item.telefone}</td>
                                    
                                    <td><button class="btn  btn-primary btnEditar"  id="btnEditar">Editar</button></td>
                                    <td><button class="btn btn-danger btnExcluir" id="btnExcluir"  onclick="avaliarExlusao(${item.codigo});">Excluir</button></td>
                                    <td>${funcionario.chave}</td>
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>





                </div>

            </div>     
        </div>



        
        


    </body>
</html>
