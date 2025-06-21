package com.hammerandshield.notesspringboot.repository;

import com.hammerandshield.notesspringboot.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotesRepository extends JpaRepository<Note, UUID> {
}
