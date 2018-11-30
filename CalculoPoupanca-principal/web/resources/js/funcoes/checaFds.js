$('td:first-child').each(function() {

    var dataTexto = $(this).text();
    var dataDividida = dataTexto.split("/");
    var dataFormatoSql = dataDividida[2]+'-'+dataDividida[1]+'-'+dataDividida[0]
    var data = new Date(dataFormatoSql);

    if(data.getDay() == 6 || data.getDay() == 0){
        $(this).parent().addClass("cor-unselectable");
        $(this).parent().addClass("unselectable");
    } 
});