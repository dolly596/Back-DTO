package com.atividade.dto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.dto.dto.AtividadeDTORecord;
import com.atividade.dto.entities.AtividadeDTO;
import com.atividade.dto.service.AtividadeDTOService;

import jakarta.validation.Valid;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class AtividadeDTOController {
		
		private final AtividadeDTOService atividadeDTOService;

		@Autowired
		public AtividadeDTOController(AtividadeDTOService atividadeDTOService) {
			this.atividadeDTOService = atividadeDTOService;
		}

		@GetMapping ("/{id}")

		public ResponseEntity<AtividadeDTO> buscaUsuarioIdControlId (@ PathVariable Long id) {
			AtividadeDTO usuario = atividadeDTOService.buscaUsuarioId(id);
			if (usuario != null) {
				return ResponseEntity.ok(usuario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/")
		public ResponseEntity<List<AtividadeDTO>> buscaTodosUsuarioControl(){
			List<AtividadeDTO> usuario = atividadeDTOService.buscaTodosUsuarios();
			return ResponseEntity.ok(usuario);
		}
		@PostMapping("/")
		public ResponseEntity<AtividadeDTORecord> salvaUsuarioControl(@RequestBody  @Valid AtividadeDTORecord atividadeDTORecord){
			AtividadeDTORecord salvaUsuarios= atividadeDTOService.salvaUsuario(atividadeDTORecord);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaUsuarios);
		}
		@PutMapping("/{id}")
		public ResponseEntity<AtividadeDTORecord> alterarUsuarioControl(@PathVariable Long id, @RequestBody @Valid AtividadeDTORecord atividadeDTORecord){
			AtividadeDTORecord alterarUsuario = atividadeDTOService.alterarUsuario(id, atividadeDTORecord);
			if(alterarUsuario != null) {
				return ResponseEntity.ok(alterarUsuario);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<AtividadeDTO> apagaUsuarioControl(@PathVariable Long id){
			boolean usuario = atividadeDTOService.apagarUsuario(id);
			if (usuario) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}
