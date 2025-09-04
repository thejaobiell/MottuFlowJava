package com.sprint.MottuFlow.domain.autenticao;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin( @NotBlank String email, @NotBlank String senha ) {}
