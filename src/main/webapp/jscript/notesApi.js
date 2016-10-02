$("#refresh").click(
    $( document ).ready(function() {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState == XMLHttpRequest.DONE) {
                var response = xhr.responseText.substring(1, xhr.responseText.length-1);
                response = response.split("},");
                var  notes = "";
                for (i in response) {
                    if (response[i][response[i].length-1] != "}") {
                        var note = JSON.parse(response[i] + "}");
                    } else {
                        var note = JSON.parse(response[i]);
                    }
                    notes += note.author + ":    " + note.text + "\n____________________________________________________________\n\n";
                }
                $("#resultBox").text(notes);
            }
        }
        xhr.open('GET', 'http://www.artemdudkov.com/aurora/notes/all', true);
        xhr.send(null);
    })
);

$("#addNotes").click(function() {
    var xhr = new XMLHttpRequest();
    var text = "";
    var author = "";
    var note = {};

    text = $("#newNote").val();
    author = $("#author").val();

    if(text == "") {
        alert("Note is empty!");
    } else if (author == ""){
        alert("No author. Please sign your note.");
    } else {
        xhr.open('POST', 'http://www.artemdudkov.com/aurora/notes/post', true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify({text:text, author:author}));
        location.reload();
    }
});