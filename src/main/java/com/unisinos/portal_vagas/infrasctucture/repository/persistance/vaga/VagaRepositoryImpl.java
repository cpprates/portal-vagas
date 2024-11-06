package com.unisinos.portal_vagas.infrasctucture.repository.persistance.vaga;

import com.unisinos.portal_vagas.domain.data.model.vaga.VagaFilter;
import com.unisinos.portal_vagas.domain.data.model.vaga.Vaga;
import com.unisinos.portal_vagas.domain.repositories.vaga.VagaRepository;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.vaga.VagaDocument;
import com.unisinos.portal_vagas.infrasctucture.data.mapper.vaga.VagaDocumentMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VagaRepositoryImpl implements VagaRepository {

    private VagaMongoRepository vagaMongoRepository;
    private VagaDocumentMapper vagaDocumentMapper;
    private MongoTemplate mongoTemplate;

    public VagaRepositoryImpl(
            VagaMongoRepository vagaMongoRepository,
            VagaDocumentMapper vagaDocumentMapper,
            MongoTemplate mongoTemplate) {
        this.vagaMongoRepository = vagaMongoRepository;
        this.vagaDocumentMapper = vagaDocumentMapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Vaga criar(Vaga vaga) {
        VagaDocument vagaDocument = vagaDocumentMapper.convertToVagaDocument(vaga);
        VagaDocument vagaSaved = vagaMongoRepository.save(vagaDocument);
        return vagaDocumentMapper.convertToVaga(vagaSaved);
    }

    @Override
    public List<Vaga> buscarVagaPorFiltro(VagaFilter vagaFilter) {
        Query query = new Query();

        if (vagaFilter.getTitulo() != null && !vagaFilter.getTitulo().isEmpty()) {
            query.addCriteria(Criteria.where("titulo").regex(vagaFilter.getTitulo(), "i"));
        }
        if (vagaFilter.getLocalizacao() != null && !vagaFilter.getLocalizacao().isEmpty()) {
            query.addCriteria(Criteria.where("localizacao").regex(vagaFilter.getLocalizacao(), "i"));
        }
        if (vagaFilter.getEmpresa() != null && !vagaFilter.getEmpresa().isEmpty()) {
            query.addCriteria(Criteria.where("empresa").regex(vagaFilter.getEmpresa(), "i"));
        }

        return mongoTemplate.find(query, VagaDocument.class).stream()
                .map(vagaDocumentMapper::convertToVaga)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vaga> buscarPorId(String id) {
        Optional<VagaDocument> vagaDocument = vagaMongoRepository.findById(id);
        return vagaDocument.map(vagaDocumentMapper::convertToVaga);
    }

    @Override
    public Vaga atualizar(String id, Vaga vaga) {
        VagaDocument document = vagaDocumentMapper.convertToVagaDocument(vaga);
        document.setId(id);
        VagaDocument documentSaved = vagaMongoRepository.save(document);
        return vagaDocumentMapper.convertToVaga(documentSaved);
    }

    @Override
    public void deletar(String id) {
        vagaMongoRepository.deleteById(id);
    }
}
