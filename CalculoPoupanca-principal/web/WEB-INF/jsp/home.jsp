<%-- 
    Document   : cadastro
    Created on : 15/11/2018, 10:18:33
    Author     : PC_LENOVO
--%>
<%@page import="br.com.calculopoupanca.dao.FuncionarioDAO"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="<c:url value="resources/js/plugins/jquery-3.2.1.min.js"/>" type="text/javascript"></script>
        <link href="<c:url value="resources/css/home.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/dataTables.bootstrap.css" /> "  rel="stylesheet" type="text/css"/>
         <link href="<c:url value="resources/css/jquery.dataTables.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/js/plugins/font-awesome-4.7.0/css/font-awesome.min.css" />" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="resources/js/plugins/bootstrap.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/plugins/jquery.mask.js"/>" type="text/javascript"></script>
        <script src="<c:url value="resources/js/plugins/jquery.bootgrid-1.3.1/jquery.bootgrid.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/plugins/jquery.bootgrid-1.3.1/jquery.bootgrid.fa.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="resources/js/home.js"/>" type="text/javascript"></script>
        <script src="<c:url value="resources/js/novoCalculo.js"/>" type="text/javascript"></script>
         <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
         <link href="<c:url value="resources/css/jquery.dataTables.min.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/jquery.dataTables.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/novoCalculo.css"/>" rel="stylesheet" type="text/css"/>
        <script src="<c:url value="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="resources/js/sweetalert.js"/>" type="text/javascript"></script>
        <link rel="shortcut icon" href="<c:url value="resources/img/bancobrasil.png"/>" />
</head>
         
         
        <title>Calculo de planos econômicos</title>
       
    </head>
    <body>
       
        <div id="loading" style="position:fixed; top:50% ;left:50%;z-index:1051"><img src='<c:url value="resources/img/carregando_1.gif"/>' width="48" height="48" /></div>        
       
        <div class = "page-header"></div>
        <div class = "navbar navbar-cor-bb navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class = "navbar-brand" style="margin-top:-6px; font-weight: 700; font-family: arial" href="https://www.bb.com.br" title="Voltar para página do Cenop Serviços curitiba">
                        <img class="img-responsive" style="display:inline-block; height:42px; margin-top:-5px; margin-right:10px" src="<c:url value="resources/img/bancobrasil3.png"/>" alt="logo" />
                        Cálculo Planos Econômicos
                    </a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarButtons">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>                   
                </div>
                <div class="navbar-collapse collapse" id="navbarButtons" style="float: right">
                    <ul class = "nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Menu<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a  id="botao_novo_calculo" href="#">Novo cálculo</a></li>
                                <li><a  id="botao_calculo_anterior" href="#">Consultar cálculos anteriores</a></li>
                                <li><a  id="botao_correcao_monetaria" href="#">Cálculo personalizado</a></li>
                                <li><a  id="botao_gsv" href="#">Consultar gsv</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        
        
        
        
        
           <div class="container">
               <div id="conteudo" class="container" ></div>
        </div>
       
       
    </body>
      <footer class="navbar-fixed-bottom" style="background-color: #d1d1d1">
        <div class = "container">
            <p id = "rodape" style="color: rgb(30, 73, 115); margin-bottom: 0px; font-weight: 600;"></p>
        </div>
    </footer>
    
    
    
    
</html>
