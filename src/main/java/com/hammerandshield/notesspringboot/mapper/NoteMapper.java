package com.hammerandshield.notesspringboot.mapper;

import com.hammerandshield.notesspringboot.dto.CreateUpdateNoteRequest;
import com.hammerandshield.notesspringboot.dto.NoteResponse;
import com.hammerandshield.notesspringboot.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteResponse toResponse(Note note);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Note fromCreateRequest(CreateUpdateNoteRequest request);

    List<NoteResponse> toResponseList(List<Note> notes);
}
