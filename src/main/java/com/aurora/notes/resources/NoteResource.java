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

    @RequestMapping(value = {"/all", "/all/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = {"/post", "/post/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newNote(@RequestBody Note note) {
        noteService.newNote(note);
        return new ResponseEntity<>("New message added",HttpStatus.OK);
    }

}
