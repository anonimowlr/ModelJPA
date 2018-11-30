$(document).ready(function () {
    $('#loading').hide();
    
       
    
   
 
    
    
    $('#testeControler').on('click', function () {
         $.ajax({
        url: 'testeControler'
    }).done(function (resposta) {
        $('#conteudo').append(resposta);
    });
    });
    
    
    $('#jurosRem').on('focusin', function () {
         $.ajax({
        url: 'novo-calculo'
    }).done(function (resposta) {
        $('#conteudo').append(resposta);
    });
    });
    
    
  
    
    
    

});


 




$(document)
    .ajaxStart(function () {
        $('#loading').show();
    })
    .ajaxStop(function () {
        $('#loading').hide();
    });