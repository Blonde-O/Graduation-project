$(function () {
    /*$('#convert').click(function () {
        let arg1 = $('#arg1').val();
        let arg2 = $('#arg2').val();
        let arg3 = $('#arg3').val();
        if (!arg1) {
            $('#arg1').css("border-color", "red");
        } else {
            $('#arg1').css("border-color", "");
        }
        if (!arg1) {
            alert('Укажите значение!')
            return;
        }
        if (arg1 < 0) {
            alert('Укажите неотрицательное значение!')
            return;
        }*/
        $.ajax({
            url: 'student/questions?arg1=0',
            type: 'GET',
            success: function (result) {
                $.each(result, function (index, value) {
                    var text=value.text;
                    var var1=value.var1;
                    var var2=value.var2;
                    var var3=value.var3;
                    var var4=value.var4;
                    var question = '#question'+index;
                    $(question).html(text+ '<br>1. ' +var1+ '<br>2. ' +var2+ '<br>3. ' +var3+ '<br>4. ' +var4)});
            }
        });
   });
//});