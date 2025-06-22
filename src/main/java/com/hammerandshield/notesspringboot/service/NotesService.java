package com.hammerandshield.notesspringboot.service;

import com.hammerandshield.notesspringboot.dto.CreateUpdateNoteRequest;
import com.hammerandshield.notesspringboot.dto.NoteResponse;
import com.hammerandshield.notesspringboot.entity.Note;
import com.hammerandshield.notesspringboot.mapper.NoteMapper;
import com.hammerandshield.notesspringboot.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NotesService {

    private final NotesRepository notesRepository;
    private final NoteMapper noteMapper;

    public NotesService(NotesRepository notesRepository, NoteMapper noteMapper) {
        this.notesRepository = notesRepository;
        this.noteMapper = noteMapper;
    }

    public List<NoteResponse> findAll() {
        List<Note> notes = notesRepository.findAll();
        return noteMapper.toResponseList(notes);
    }

    public NoteResponse findById(UUID id) throws NoSuchElementException {
        Note note = notesRepository.findById(id).orElseThrow();
        return noteMapper.toResponse(note);
    }

    public NoteResponse save(CreateUpdateNoteRequest noteRequest) {
        Note savedNote = notesRepository.save(noteMapper.fromCreateRequest(noteRequest));
        return noteMapper.toResponse(savedNote);
    }

    public NoteResponse deleteById(UUID id) throws NoSuchElementException {
        Note note = notesRepository.findById(id).orElseThrow();
        notesRepository.delete(note);
        return noteMapper.toResponse(note);
    }

}
