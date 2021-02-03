package com.note.service;

import com.note.modal.Note;

public interface NoteService {

	Note addNote(Note note, long id);

	Note editNote(Note note, long id);

	void deleteNote(long id);

	Note findNote(long id);

}
