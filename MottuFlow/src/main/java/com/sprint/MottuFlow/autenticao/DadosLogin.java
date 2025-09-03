package com.sprint.MottuFlow.autenticao;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin( @NotBlank String email, @NotBlank String senha ) {}
