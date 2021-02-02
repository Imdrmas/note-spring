package com.note.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.note.dao.CategoryDao;
import com.note.dao.NoteDao;
import com.note.modal.Category;
import com.note.modal.Note;
import com.note.service.NoteService;

@Transactional
@Component
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Note addNote(Note note, long id) {
		Category category = categoryDao.findById(id).orElse(null);
		note.setCreateAt(new Date());
		category.addNote(note);
		return noteDao.save(note);
	}

	@Override
	public Note editNote(Note note, long id) {
		Note existsNote = noteDao.findById(id).orElse(null);
		existsNote.setUpdateAt(new Date());
		existsNote.setTitle(note.getTitle());
		existsNote.setContent(note.getContent());
		return noteDao.save(note);
	}

	@Override
	public void deleteNote(long id) {
		noteDao.deleteById(id);
	}

	@Override
	public Note findNote(long id) {
		return noteDao.findById(id).orElse(null);
	}

	@Override
	public List<Note> findNotes(long id) {
		Category category = categoryDao.findById(id).orElse(null);
		List<Note> notes = category.getNotes();
		notes = notes.stream().sorted(Comparator.comparing(Note::getTitle).reversed()).collect(Collectors.toList());
		return notes;
	}

}
