package com.amigoscode;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MembroController {

    private final MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @QueryMapping
    public List<Membro> membros() {
        return membroService.listarTodos();
    }

    @QueryMapping
    public Membro membro(@Argument String id) {
        return membroService.buscarPorId(id);
    }

    @MutationMapping
    public Membro criarMembro(
            @Argument String nome,
            @Argument String email
    ) {
        return membroService.criar(nome, email);
    }

    @MutationMapping
    public Membro atualizarMembro(
            @Argument String id,
            @Argument String nome,
            @Argument String email
    ) {
        return membroService.atualizar(id, nome, email);
    }

    @MutationMapping
    public Boolean deletarMembro(
            @Argument String id
    ) {
        return membroService.deletar(id);
    }
}