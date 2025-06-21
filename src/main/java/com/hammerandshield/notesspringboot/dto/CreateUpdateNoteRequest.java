package com.hammerandshield.notesspringboot.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUpdateNoteRequest(
        @NotBlank String title,
        @NotBlank String content
) {}