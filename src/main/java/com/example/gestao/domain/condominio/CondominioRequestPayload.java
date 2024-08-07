package com.example.gestao.domain.condominio;

import java.util.UUID;

public record CondominioRequestPayload(UUID id, String nome, String endereco, int quantidadeDeUnidades) {
}
