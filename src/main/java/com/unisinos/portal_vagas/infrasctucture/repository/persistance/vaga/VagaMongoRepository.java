package com.unisinos.portal_vagas.infrasctucture.repository.persistance.vaga;

import com.unisinos.portal_vagas.infrasctucture.data.model.document.vaga.VagaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaMongoRepository extends MongoRepository<VagaDocument, String> {
}
