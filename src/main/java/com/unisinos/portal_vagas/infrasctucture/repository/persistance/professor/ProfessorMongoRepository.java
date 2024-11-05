package com.unisinos.portal_vagas.infrasctucture.repository.persistance.professor;

import com.unisinos.portal_vagas.infrasctucture.data.model.document.professor.ProfessorDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorMongoRepository extends MongoRepository<ProfessorDocument, String> {
}
