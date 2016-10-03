$("#refresh").click(function() {
    location.reload();
    $( document ).ready(function(){
        console.log("reloaded");
    })});

$("#addNotes").click(function() {
    alert("addNote pressed!")
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
        // xhr.open('POST', 'http://localhost:8080/notes/post', true);
        xhr.open('POST', 'http://www.artemdudkov.com:8080/aurora/notes/post', true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify({text:text, author:author}));
        location.reload();
    }
});