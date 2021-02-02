package com.note.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.note.modal.Note;

public interface NoteDao extends JpaRepository<Note, Long> {

}
