package com.demo.academiacx.controller;

import com.demo.academiacx.model.dto.EnderecoDto;
import com.demo.academiacx.service.EnderecoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/address")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {

        List<EnderecoDto> response = enderecoService.findAll();
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        EnderecoDto response = enderecoService.findById(id);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);

    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody EnderecoDto enderecoDto){

        EnderecoDto response = enderecoService.save(enderecoDto);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody EnderecoDto enderecoDto){

        EnderecoDto response = enderecoService.update(enderecoDto);
        return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id") Long id){
        enderecoService.delete(id);
        return true;
    }

    @RequestMapping(value = {"/app"}, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app.html");
        return modelAndView;
    }


}
