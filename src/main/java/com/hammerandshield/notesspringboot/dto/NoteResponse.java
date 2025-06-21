package com.hammerandshield.notesspringboot.dto;

import java.time.Instant;
import java.util.UUID;

public record NoteResponse(
        UUID id,
        String title,
        String content,
        Instant createdAt,
        Instant updatedAt
) {}