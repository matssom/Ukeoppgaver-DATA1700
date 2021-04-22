$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();
    henteEnMotorvogn();
});

function hentAlleBiler() {
    $.get( "/api/6/biler", function( biler ) {
        formaterBiler(biler);
    })
    .fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feil").html(json.message);
    });
}

function formaterBiler(biler){
    let ut = "<select id='valgtMerke' onchange='finnTyper()'>";
    let forrigeMerke = "";
    ut+="<option>Velg merke</option>";
    for (const bil of biler){
        if(bil.merke !== forrigeMerke){
            ut+="<option>"+bil.merke+"</option>";
        }
        forrigeMerke = bil.merke;
    }
    ut+="</select>";
    $("#merke").html(ut);
}

function finnTyper(){
    const valgtMerke = $("#valgtMerke").val();
    $.get( "/api/6/biler", function( biler ) {
        formaterTyper(biler,valgtMerke);
    })
    .fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feil").html(json.message);
    });
}
function formaterTyper(biler,valgtMerke){
    let ut = "<select id='valgtType'>";
    for(const bil of biler ){
        if(bil.merke === valgtMerke){
            ut+="<option>"+bil.type+"</option>";
        }
    }
    ut+="</select>";
    $("#type").html(ut);
}

function henteEnMotorvogn(){
    const id = window.location.search.substring(1); // kommer fra kallet i index.js
    const url = "/api/6/motorvogn?id="+id;
    $.get( url, function(enMotorVogn) {
        // overfør til input-feltene i skjemaet
        $("#id").val(enMotorVogn.id); // må ha med denne for å vite hvilken id
        $("#personnr").val(enMotorVogn.personnr);
        $("#navn").val(enMotorVogn.navn);
        $("#adresse").val(enMotorVogn.adresse);
        $("#kjennetegn").val(enMotorVogn.kjennetegn);
        $("#merke").val(enMotorVogn.merke);
        $("#type").val(enMotorVogn.type);
    })
    .fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feil").html(json.message);
    });
}

function endreMotorvogn() {
    const motorvogn = {
        id : $("#id").val(),
        personnr : $("#personnr").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        merke : $("#valgtMerke").val(),
        type : $("#valgtType").val(),
    };
    $.ajax({
        url: '/api/6/motorvogn',
        type: 'PUT',
        data: motorvogn,
        success: (res) => {
            hentAlle()
        },
        error: (jqXhr, textStatus, errorMessage) => {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        }
    })

    window.location.href="index.html";
}


