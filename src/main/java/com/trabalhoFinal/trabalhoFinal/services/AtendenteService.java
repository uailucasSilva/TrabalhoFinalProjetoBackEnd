package com.trabalhoFinal.trabalhoFinal.services;
import com.trabalhoFinal.trabalhoFinal.models.Atendente;
import com.trabalhoFinal.trabalhoFinal.enums.NivelDeAcesso;
import com.trabalhoFinal.trabalhoFinal.repositories.AtendenteRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.vo.AtendenteVOMapper;
import com.trabalhoFinal.trabalhoFinal.services.mapper.entity.AtendenteMapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository repository;

    @Autowired
    private AtendenteVOMapper atendenteVOMapper;

    @Autowired
    private AtendenteMapper atendenteMapper;

    public AtendenteVO create(AtendenteVO atendenteVO) {
        Random random = new Random();

        Integer numeroDaMatricula = random.nextInt(10000, 9000000);
        Atendente atendente = atendenteMapper.map(atendenteVO.withNumeroDaMatricula(numeroDaMatricula.toString()));
        Atendente dbAtendente = repository.save(atendente);

        AtendenteVO newAtendenteVO = atendenteVOMapper.map(dbAtendente);
        return newAtendenteVO;
    }

    public List<AtendenteVO> getAll() {
        List<Atendente> atendentes = repository.findAll();

        List<AtendenteVO> atendenteVOList = atendentes.stream()
                .map(atendenteVOMapper::map)
                .collect(Collectors.toList());

        return atendenteVOList;
    }

    public AtendenteVO getById(Long id) {
        Atendente atendente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        AtendenteVO atendenteVO = atendenteVOMapper.map(atendente);
        return atendenteVO;
    }

    public AtendenteVO update(AtendenteVO atendenteVO, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Atendente atendente = atendenteMapper.map(atendenteVO);

        atendente.setId(id);
        Atendente updated = repository.save(atendente);

        AtendenteVO newAtendenteVO = atendenteVOMapper.map(updated);
        return newAtendenteVO;
    }

    public void delete(Long id) {
        Atendente atendente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(id);
    }

    public List<AtendenteVO> getByNvl(String nvl) {
        List<Atendente> atendente = repository.findByAcesso(NivelDeAcesso.valueOf(nvl));

        return atendente.stream()
                .map(atendenteVOMapper::map)
                .collect(Collectors.toList());
    }
}
