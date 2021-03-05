$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();
});

function hentAlleBiler() {
    $.get( "/3/biler", function( biler ) {
        formaterBiler(biler);
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
    $.get( "/3/biler", function( biler ) {
        formaterTyper(biler,valgtMerke);
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

function regMotorvogn() {
    const motorvogn = {
        personnr : $("#personnr").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        merke : $("#valgtMerke").val(),
        type : $("#valgtType").val(),
    };
    $.post("/3/motorvogn", motorvogn, function(){
        hentAlle();
    });
    $("#personnr").val("");
    $("#navn").val("");
    $("#adresse").val("");
    $("#kjennetegn").val("");
    $("#valgtMerke").val("");
    $("#valgtType").val("");
}

function hentAlle() {
    $.get( "/3/motorvogn", function( biler ) {
        formaterData(biler);
    });
}

function formaterData(biler) {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td></tr>";
    }
    ut += "</table>";
    $("#bilene").html(ut);
}

function slettAlle() {
    $.ajax("/3/motorvogn", {
        type: 'DELETE',
        success: () => hentAlle(),
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    });
}
