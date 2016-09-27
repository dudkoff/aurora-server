package com.aurora.notes.database;

import com.aurora.notes.model.Note;

import java.util.HashMap;
import java.util.Map;

public class NoteStorage {

    private static Map<Long, Note> notes = new HashMap<>();

    public static Map<Long, Note> getNotes() {
        return notes;
    }
}
