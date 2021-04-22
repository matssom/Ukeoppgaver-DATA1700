function validerPersonnr(){
    const personnr = $("#personnr").val();
    const regexp = /^[0-9]{11}$/;
    const ok = regexp.test(personnr);
    if(!ok){
        $("#feilPersonnummer").html("Personnummeret må bestå av 11 siffer");
        return false;
    }
    else{
        $("#feilPersonnummer").html("");
        return true;
    }
}

function validerNavn(){
    const navn = $("#navn").val();
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    const ok = regexp.test(navn);
    if(!ok){
        $("#feilNavn").html("Navnet må bestå av 2 til 20 bokstaver");
        return false;
    }
    else{
        $("#feilNavn").html("");
        return true;}
}

function validerAdresse(){
    const adresse = $("#adresse").val();
    const regexp = /[0-9a-zA-ZæøåÆØÅ. \-]{2,30}$/;
    const ok = regexp.test(adresse);
    if(!ok){
        $("#feilAdresse").html("Adressen må bestå av 2 til 40 bokstaver og tall");
        return false;
    }
    else{
        $("#feilAdresse").html("");
        return true;}
}

function validerKjennetegn() {
    const kjennetegn = $("#kjennetegn").val();
    const regexp = /^[A-Z][A-Z][0-9]{5}$/;
    const ok = regexp.test(kjennetegn);
    if (!ok) {
        $("#feilKjennetegn").html("Kjennetegnet må ha to store bokstaver og 5 tall");
        return false;
    } else {
        $("#feilKjennetegn").html("");
        return true;
    }
}

function validerMerke(){
    const merke = $("#valgtMerke").val();
    if(merke==="Velg merke"){
        $("#feilMerke").html("Velg et merke!");
        return false;
    }
    else{
        $("#feilMerke").html("");
        return true;
    }
}

function ingenValideringsFeil(){
    return ( validerPersonnr() && validerNavn() && validerAdresse() && validerKjennetegn() && validerMerke() );
}