package com.demo.academiacx.controller;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.dto.ClienteDto;
import com.demo.academiacx.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ClienteDto> response = clienteService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        ClienteDto response = clienteService.findById(id);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClienteDto clienteDto){

        ClienteDto response = clienteService.save(clienteDto);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto){
        ClienteDto response = clienteService.update(clienteDto);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id") Long id){
       return clienteService.delete(id);
    }

    @GetMapping("/{username}")
    public ClienteDto filter(@RequestParam(value = "username", required = true) String username){
        return clienteService.findByUsername(username);
    }

//    @GetMapping("/")
//    public ClienteDto findByUsernameAndPassword(@RequestParam(value = "username") String username,
//                                                @RequestParam(value = "password") String password){
//        return clienteService.findByUsernameAndPassword(username, password);
//    }


    @GetMapping("/")
    public String exibirIndex(ClienteModel clienteModel){
        return "index.html";
    }

    @PostMapping("/efetuarLogin")
    public String efetuarLogin(ClienteModel clienteModel){
        if(clienteModel.getUsername().equals("admin") &&
            clienteModel.getPassword().equals("senha123")){
            return "redirect:/app.html";
        } else {
            return "redirect:/";
        }
    }
}
