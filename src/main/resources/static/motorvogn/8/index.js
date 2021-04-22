function loggInn() {
    if(loggInnValideringOK()){
        const url = "/api/8/loggInn?brukernavn="+$("#brukernavn").val()+"&passord="+$("#passord").val();
        $.get( url, function( OK ) {
            if(OK){
                window.location.href="/motorvogn/8/liste.html";
            }
            else{
                $("#feil").html("Feil i brukernavn eller passord");
            }
        })
        .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
    }
}