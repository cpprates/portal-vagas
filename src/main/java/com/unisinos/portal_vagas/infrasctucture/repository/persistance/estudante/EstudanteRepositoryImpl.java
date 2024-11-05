package com.unisinos.portal_vagas.infrasctucture.repository.persistance.estudante;

import com.unisinos.portal_vagas.domain.data.filters.estudante.EstudanteFilter;
import com.unisinos.portal_vagas.domain.data.model.estudante.Estudante;
import com.unisinos.portal_vagas.domain.repositories.estudante.EstudanteRepository;
import com.unisinos.portal_vagas.infrasctucture.data.model.document.estudante.EstudanteDocument;
import com.unisinos.portal_vagas.infrasctucture.mappers.estudante.EstudanteDocumentMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EstudanteRepositoryImpl implements EstudanteRepository {

    private EstudanteMongoRepository estudanteMongoRepository;
    private EstudanteDocumentMapper estudanteDocumentMapper;
    private MongoTemplate mongoTemplate;

    public EstudanteRepositoryImpl(
            EstudanteMongoRepository estudanteMongoRepository,
            EstudanteDocumentMapper estudanteDocumentMapper,
            MongoTemplate mongoTemplate) {
        this.estudanteMongoRepository = estudanteMongoRepository;
        this.estudanteDocumentMapper = estudanteDocumentMapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Estudante criarPerfilEstudante(Estudante estudante) {
        EstudanteDocument estudanteDocument = estudanteDocumentMapper.convertToEstudanteDocument(estudante);
        EstudanteDocument estudanteCriado = estudanteMongoRepository.save(estudanteDocument);
        return estudanteDocumentMapper.convertToEstudante(estudanteCriado);
    }

    @Override
    public List<Estudante> listarEstudantePorFiltro(EstudanteFilter estudanteFilter) {
        Query query = new Query();

        if (estudanteFilter.getNome() != null && !estudanteFilter.getNome().isEmpty()) {
            query.addCriteria(Criteria.where("nome").regex(estudanteFilter.getNome(), "i"));
        }
        if (estudanteFilter.getCurso() != null && !estudanteFilter.getCurso().isEmpty()) {
            query.addCriteria(Criteria.where("curso").regex(estudanteFilter.getCurso(), "i"));
        }
        if (estudanteFilter.getHabilidades() != null && !estudanteFilter.getHabilidades().isEmpty()) {
            List<Criteria> habilidadeCriteria = estudanteFilter.getHabilidades().stream()
                    .map(habilidade -> Criteria.where("habilidades").regex(habilidade, "i"))
                    .collect(Collectors.toList());
            query.addCriteria(new Criteria().andOperator(habilidadeCriteria.toArray(new Criteria[0])));
        }
        if (estudanteFilter.getTecnologias() != null && !estudanteFilter.getTecnologias().isEmpty()) {
            List<Criteria> tecnologiaCriteria = estudanteFilter.getTecnologias().stream()
                    .map(tecnologia -> Criteria.where("tecnologias").regex(tecnologia, "i"))
                    .collect(Collectors.toList());
            query.addCriteria(new Criteria().andOperator(tecnologiaCriteria.toArray(new Criteria[0])));
        }

        return mongoTemplate.find(query, EstudanteDocument.class).stream()
                .map(estudanteDocumentMapper::convertToEstudante)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Estudante> buscarPorId(String id) {
        Optional<EstudanteDocument> estudanteDocument = estudanteMongoRepository.findById(id);
        return estudanteDocument.map(estudanteDocumentMapper::convertToEstudante);
    }

    @Override
    public Estudante atualizar(String id, Estudante estudante) {
        EstudanteDocument estudanteDocument = estudanteDocumentMapper.convertToEstudanteDocument(estudante);
        estudanteDocument.setId(id);
        EstudanteDocument estudanteAtualizado = estudanteMongoRepository.save(estudanteDocument);
        return estudanteDocumentMapper.convertToEstudante(estudanteAtualizado);
    }

    @Override
    public void deletar(String id) {
        estudanteMongoRepository.deleteById(id);
    }
}
