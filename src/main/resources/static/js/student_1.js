window.onload = function getQuestions() {
    $.get("/student/questions", function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i].text);
            $("#q").append('<p id="' + i + '">'
                + '<label htmlFor="' + i + '">' +(i + 1) + '.&nbsp;' + data[i].text+ '</label>')
                .append(
                    '<input type="radio" id="' + data[i].id +
                    '"name="' + data[i].id + '" value="1">' +
                    '<label htmlFor="' + data[i].id + '">' + data[i].var1 + '</label>',
                    '<input type="radio" id="' + data[i].id +
                    '"name="' + data[i].id + '" value="2">' +
                    '<label htmlFor="' + data[i].id + '">' + data[i].var2 + '</label>',
                    '<input type="radio" id="' + data[i].id +
                    '"name="' + data[i].id + '" value="3">' +
                    '<label htmlFor="' + data[i].id + '">' + data[i].var3 + '</label>',
                    '<input type="radio" id="' + data[i].id +
                    '"name="' + data[i].id + '" value="4">' +
                    '<label htmlFor="' + data[i].id + '">' + data[i].var4 + '</label>');
        }
    }, "json")
        .fail(function () {
            $("#rep")
                .append('<br/><p style="color:red">Oops! Error with XMLHttpRequest</p>')
        });
}