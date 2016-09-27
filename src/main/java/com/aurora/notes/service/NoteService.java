package com.aurora.notes.service;

import com.aurora.notes.database.NoteStorage;
import com.aurora.notes.model.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NoteService {
    private Map<Long, Note> notes = NoteStorage.getNotes();

    public NoteService() {
        notes.put(1L, new Note(1L, "Don't forget to make second note", "dudkoff"));
        notes.put(2L, new Note(2L, "I didn't", "dudkoff"));
    }

    public List<Note> getAllNotes(){
        return new ArrayList<>(notes.values());
    }

    public void newNote(Note note){
        note.setCreated(new Date());
        note.setId((long) (notes.size() + 1));
        notes.put((long) (notes.size() + 1), note);
    }

}
