package com.atividade.dto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.dto.dto.AtividadeDTORecord;
import com.atividade.dto.entities.AtividadeDTO;
import com.atividade.dto.repository.AtividadeDTORepository;

@Service
public class AtividadeDTOService {
	
	private final AtividadeDTORepository AtividadeDTORepository;

	@Autowired
	public AtividadeDTOService(AtividadeDTORepository AtividadeDTORepository) {
		this.AtividadeDTORepository = AtividadeDTORepository;
	}

	public List<AtividadeDTO> buscaTodosUsuarios(){
		return AtividadeDTORepository.findAll();
	}

	public AtividadeDTO buscaUsuarioId (Long id) {
		Optional <AtividadeDTO> Usuario = AtividadeDTORepository.findById(id);
		return Usuario.orElse(null);			
	}

	public AtividadeDTORecord salvaUsuario(AtividadeDTORecord atividadeDTORecord) {
		AtividadeDTO Usuario = new AtividadeDTO (atividadeDTORecord.nome(), atividadeDTORecord.senha());
		AtividadeDTO salvarUsuario = AtividadeDTORepository.save(Usuario);
		return new AtividadeDTORecord(salvarUsuario.getId(), salvarUsuario.getNome(), salvarUsuario.getSenha());
	}

	public AtividadeDTORecord alterarUsuario(Long id, AtividadeDTORecord atividadeDTORecord) {
		AtividadeDTO existeUsuario = AtividadeDTORepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
		existeUsuario.setNome(atividadeDTORecord.nome());
		existeUsuario.setNome(atividadeDTORecord.senha());
		
		AtividadeDTO atualizarUsuario = AtividadeDTORepository.save(existeUsuario);
		return new AtividadeDTORecord(atualizarUsuario.getId(), atualizarUsuario.getNome(), atualizarUsuario.getSenha());
	}

	public boolean apagarUsuario(Long id) {
		Optional <AtividadeDTO> existeUsuario = AtividadeDTORepository.findById(id);
		if (existeUsuario.isPresent()) {
			AtividadeDTORepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<AtividadeDTO> buscarTodos(){
		return AtividadeDTORepository.findAll();
	}
	public AtividadeDTO buscarPorId (Long id){
		Optional <AtividadeDTO> usuario = AtividadeDTORepository.findById(id);
		return usuario.orElse(null);
	}
}
