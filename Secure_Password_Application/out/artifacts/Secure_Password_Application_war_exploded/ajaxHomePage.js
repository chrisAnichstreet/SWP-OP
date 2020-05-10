$(document).ready(function(){
    console.log("Test0");
    $('#Portalgun')

        console.log("Test1");
        $('#bring').click(function(){
            console.log("Hey Jetz kommt Ajax.");

            /* "this" sprich der value (=die Kategorie) aus der JSP wird nicht als id Festgelegt, Überprüfen*/
            //console.log($(this).html());
            frage_id = "fizz";
            answer_id = "buzz";

            $.ajax({
                url:'homepage',
                type: 'POST',
                dataType: 'json',
                data: {value:$("openPortal").html(), frage_id: frage_id, answer_id: answer_id},
                success: function(data)
                {

                    min = 0;
                    max = 3;
                    var rand = (Math.random() * (max - min)) + min;
                    rand = Math.round(rand);

                    console.log(rand);
                    text = "<div style='text-align: center; font-family: Impact; font-weight: bold'>";

                    text += '<a href="'+data.portal+'">';

                    if(rand == 0)
                    {
                        text += '<IMG Src="https://media.giphy.com/media/yg5CaBHazViSY/giphy.gif">';
                    }
                    if(rand == 1)
                    {
                        text += '<IMG Src="https://media.giphy.com/media/11p6pFpPYIAzS0/giphy.gif">';
                    }
                    if(rand == 2)
                    {
                        text += '<IMG Src="https://media.giphy.com/media/cHgN1BeB8o836/giphy.gif">';
                    }
                    if(rand == 3)
                    {
                        text += '<IMG Src="https://media.giphy.com/media/HjeIqm3MxURFK/giphy.gif">';
                    }
                    text += '</a><p>To Infinity And Beyond!</p></div>';
                    console.log("TEXT :"+text);
                    $("#Portal").html(text);
                }
            });
            return false;
        });


    });