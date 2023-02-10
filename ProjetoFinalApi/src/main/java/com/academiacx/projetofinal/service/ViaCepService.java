package com.academiacx.projetofinal.service;


import com.academiacx.projetofinal.model.ViaCepModel;
import com.academiacx.projetofinal.repository.CepRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ViaCepService {

    private RestTemplate restTemplate = new RestTemplate();

    private final CepRepository cepRepository;

    private final ModelMapper modelMapper;

    public ViaCepService(CepRepository cepRepository, ModelMapper modelMapper) {
        this.cepRepository = cepRepository;
        this.modelMapper = modelMapper;
    }


    public ViaCepModel getViaCep(String cep)
    {
        String url = "http://viacep.com.br/ws/" + cep + "/json/ ";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<ViaCepModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, ViaCepModel.class);

        return responseEntity.getBody();
    }

    public Optional<ViaCepModel> cadastrarCep(ViaCepModel viaCepModel) {

        cepRepository.save(viaCepModel);


        return Optional.of(cepRepository.save(viaCepModel));
    }

    public List<ViaCepModel> findAll() {
        List<ViaCepModel> viaCepModels = cepRepository.findAll();


        return modelMapper.map(viaCepModels, new TypeToken<List<ViaCepModel>>() {
        }.getType());
    }

}
