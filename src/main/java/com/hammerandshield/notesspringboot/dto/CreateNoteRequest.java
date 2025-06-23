package com.hammerandshield.notesspringboot.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateNoteRequest(
        @NotBlank String title,
        @NotBlank String content
) {}