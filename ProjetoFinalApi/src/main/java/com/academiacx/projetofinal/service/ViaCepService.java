package com.academiacx.projetofinal.service;


import com.academiacx.projetofinal.model.ViaCepModel;
import com.academiacx.projetofinal.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Optional;

@Service
public class ViaCepService {

    private RestTemplate restTemplate = new RestTemplate();

    private final CepRepository cepRepository;

    public ViaCepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
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

}
