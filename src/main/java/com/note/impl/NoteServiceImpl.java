package com.note.impl;

import java.util.Date;

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
		existsNote.setCreateAt(null);
		return noteDao.save(existsNote);
	}

	@Override
	public void deleteNote(long id) {
		noteDao.deleteById(id);
	}

	@Override
	public Note findNote(long id) {
		return noteDao.findById(id).orElse(null);
	}

}
