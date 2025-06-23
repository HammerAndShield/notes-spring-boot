package com.hammerandshield.notesspringboot.controller;

import com.hammerandshield.notesspringboot.dto.CreateNoteRequest;
import com.hammerandshield.notesspringboot.dto.NoteResponse;
import com.hammerandshield.notesspringboot.service.NotesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public List<NoteResponse> getNotes() {
        return notesService.findAll();
    }

    @GetMapping("/{id}")
    public NoteResponse getNoteById(@PathVariable UUID id) {
        return notesService.findById(id);
    }

    @PostMapping
    public NoteResponse addNote(@RequestBody CreateNoteRequest noteRequest) {
        return notesService.save(noteRequest);
    }

    @PutMapping("/{id}")
    public NoteResponse updateNote(@RequestBody CreateNoteRequest noteRequest, @PathVariable UUID id) {
        return notesService.save(noteRequest, id);
    }

    @DeleteMapping("/{id}")
    public NoteResponse deleteNote(@PathVariable UUID id) {
        return notesService.deleteById(id);
    }

}
