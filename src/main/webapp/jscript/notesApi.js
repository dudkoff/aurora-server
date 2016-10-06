$("#refresh").click(function reloadPage() {
    location.reload();
    console.log("page reloaded");
    $( document ).ready(function(){
        console.log("reloaded");
    })});

$("#addNotes").click(function() {
    console.log("attempting to adda note");
    var xhr = new XMLHttpRequest();
    var text = "";
    var author = "";
    var note = {};

    text = $("#newNote").val();
    author = $("#author").val();

    sessionStorage.setItem("author", author);

    if(text == "") {
        alert("Note is empty!");
    } else if (author == ""){
        alert("No author. Please sign your note.");
    } else {
        var url = window.location.href + "/notes/post";
        xhr.open('POST', url, true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify({text:text, author:author}));
        console.log("note added");

        location.reload();


        $("#newNote").val("");
        console.log("result is UPDATED");
    }
});

function updateResultBox() {
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
            $("#author").val(sessionStorage.getItem("author"));
        }
    }
    var url = window.location.href + "/notes/all";
    xhr.open('GET', url, true);
    xhr.send(null);
    console.log("resultbox is SET");
}
