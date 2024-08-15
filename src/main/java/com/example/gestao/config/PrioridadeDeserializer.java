package com.example.gestao.config;

import com.example.gestao.domain.tarefa.Tarefa;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class PrioridadeDeserializer extends JsonDeserializer<Tarefa.Prioridade> {
    @Override
    public Tarefa.Prioridade deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getText();
        try{
            return Tarefa.Prioridade.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IOException("Enum inválido");
        }
    }
}
