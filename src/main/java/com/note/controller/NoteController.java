package com.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note.modal.Note;
import com.note.service.NoteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping("/addNote/{id}")
	Note addNote(@RequestBody Note note, @PathVariable long id) {
		return noteService.addNote(note, id);
	}

	@PutMapping("/editNote/{id}")
	Note editNote(@RequestBody Note note, @PathVariable long id) {
		return noteService.addNote(note, id);
	}

	@DeleteMapping("/deleteNote/{id}")
	void deleteNote(@PathVariable long id) {
		noteService.deleteNote(id);
	}

	@GetMapping("/findNote/{id}")
	Note findNote(@PathVariable long id) {
		return noteService.findNote(id);
	}

	@GetMapping("/findNotes/{id}")
	List<Note> findNotes(@PathVariable long id) {
		return noteService.findNotes(id);
	}

}
