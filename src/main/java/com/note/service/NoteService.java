package com.note.service;

import java.util.List;

import com.note.modal.Note;

public interface NoteService {

	Note addNote(Note note, long id);

	Note editNote(Note note, long id);

	void deleteNote(long id);

	Note findNote(long id);

	List<Note> findNotes(long id);

}
