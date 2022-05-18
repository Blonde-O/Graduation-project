window.onload = function getResults() {
    $("#q").append('<p> №        ФИО студента        Средний балл.</p>');
    $.get("/teacher/results", function (data) {
        for (let i = 0; i < data.length; i++) {
            $("#q").append('<p id="' + i + '">'
                + '<label htmlFor="' + i + '">' + (i + 1) + '&nbsp;&nbsp;' + data[i].fio
                + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + data[i].value + '%' + '</label>');
            let elem = document.getElementById(i);
            if (data[i].value < 60) {
                elem.style.color = 'red';
            } else {
                elem.style.color = 'green';
            }
        }
    }, "json")
        .fail(function () {
            $("#rep")
                .append('<br/><p style="color:red">Oops! Error with XMLHttpRequest</p>')
        });
}