$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlleBiler();
    hentAlle();
});

function hentAlleBiler() {
    $.get( "/api/4/biler", function( biler ) {
        formaterBiler(biler);
    });
}

function formaterBiler(biler){
    let ut = "<select id='valgtMerke' onchange='finnTyper()'>";
    let i = 0;
    let forrigeMerke = "";
    ut+="<option>Velg merke</option>";
    for (const bil of biler){
        if(bil.merke != forrigeMerke){
            ut+="<option>"+bil.merke+"</option>";
        }
        forrigeMerke = bil.merke;
    }
    ut+="</select>";
    $("#merke").html(ut);
}

function finnTyper(){
    const valgtMerke = $("#valgtMerke").val();
    $.get( "/api/4/biler", function( biler ) {
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
    $.post("/api/4/motorvogn", motorvogn, function(){
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
    $.get( "/api/4/motorvogner", function( biler ) {
        formaterData(biler);
    });
}

function formaterData(biler) {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th><th></th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td>" +
            "<td> <button class='btn btn-danger' onclick='slettEnMotorvogn("+bil.personnr+")'>Slett</button></td>"+
            "</tr>";
    }
    ut += "</table>";
    $("#bilene").html(ut);
}

function slettEnMotorvogn(personnr) {
    $.ajax(`/api/4/motorvogn?personnr=${personnr}`, {
        type: 'DELETE',
        success: () => hentAlle(),
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    })
}

function slettAlle() {
    $.ajax("/api/4/motorvogner", {
        type: 'DELETE',
        success: () => hentAlle(),
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    })
}
