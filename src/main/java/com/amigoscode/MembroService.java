package com.amigoscode;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MembroService {

    private final Map<String, Membro> membros = new HashMap<>();

    public MembroService() {

        membros.put(
                "1",
                new Membro(
                        "1",
                        "Maria Oliveira",
                        "maria@email.com"
                )
        );
    }

    public List<Membro> listarTodos() {
        return new ArrayList<>(membros.values());
    }

    public Membro buscarPorId(String id) {
        return membros.get(id);
    }

    public Membro criar(String nome, String email) {

        String id = UUID.randomUUID().toString();

        Membro membro = new Membro(
                id,
                nome,
                email
        );

        membros.put(id, membro);

        return membro;
    }

    public Membro atualizar(
            String id,
            String nome,
            String email
    ) {

        Membro membro = new Membro(
                id,
                nome,
                email
        );

        membros.put(id, membro);

        return membro;
    }

    public Boolean deletar(String id) {
        return membros.remove(id) != null;
    }
}