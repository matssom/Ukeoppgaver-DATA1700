$(() => {
    $("#solveTower").click(() => {
        const tower = {
            rings: $("#rings").val(),
            fromRod: $("#fromRod").val(),
            toRod: $("#toRod").val(),
            tmpRod: $("#tmpRod").val()
        };

        $.post("/hanoi", tower, () => $.get("/hanoi", solution => format(solution)));
    });
});

const format = (solution) => {
    let msg = "<h3>Flytt</h3>";
    for (let line of solution) {
        msg += line + "<br>";
    }
    $("#solution").html(msg);
}
