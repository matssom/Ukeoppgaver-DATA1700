$(() => {
    $("#calc").click(() => {
        let number = $("#number").val();
        $.get("/faculty?number=" + number, result => $("#result").html(number + "! = " + result));
    });
});