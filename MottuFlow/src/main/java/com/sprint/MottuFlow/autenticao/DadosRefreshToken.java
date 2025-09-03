package com.sprint.MottuFlow.autenticao;

import jakarta.validation.constraints.NotBlank;

public record DadosRefreshToken( @NotBlank String refreshToken) {
}