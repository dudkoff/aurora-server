package com.aurora.notes.resources;


import com.aurora.notes.model.Note;
import com.aurora.notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteResource {

    NoteService noteService = new NoteService();

    @RequestMapping(value = {"/all", "/all/"}, method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = {"/post", "/post/"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> newNote(@RequestBody Note note) {
        noteService.newNote(note);
        return new ResponseEntity<>("New message added",HttpStatus.OK);
    }

}
