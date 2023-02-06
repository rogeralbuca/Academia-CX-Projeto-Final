package com.commerce.acdemycxfinal.model.dto.response;

import com.commerce.acdemycxfinal.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDtoResponse {

    private Long id;
    private String cpf;
    private String nome;
    private String username;
    private String password;
    private List<AddressModel> addresses;


}
