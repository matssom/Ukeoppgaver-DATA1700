function regMotorvogn() {
    const motorvogn = {
        personnr : $("#personnr").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        merke : $("#merke").val(),
        type : $("#type").val(),
    };
    $.post("/api/2/motorvogn", motorvogn, function(){
        hentAlle();
    });
    $("#personnr").val("");
    $("#navn").val("");
    $("#adresse").val("");
    $("#kjennetegn").val("");
    $("#merke").val("");
    $("#type").val("");
}

function hentAlle() {
    $.get( "/api/2/motorvogn", function( biler ) {
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
    $.ajax("/api/2/motorvogn", {
        type: 'DELETE',
        success: () => hentAlle(),
        error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
    });
}
