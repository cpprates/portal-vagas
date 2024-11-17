package com.unisinos.portal_vagas.infrasctucture.repository.persistance.estudante;

import com.unisinos.portal_vagas.infrasctucture.data.model.document.estudante.EstudanteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudanteMongoRepository extends MongoRepository<EstudanteDocument, String> {

    Optional<EstudanteDocument> findByEmail(String email);
}
