package com.luan.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luan.agenda.domain.Agenda;
import com.luan.agenda.repositories.AgendaRepository;
import com.luan.agenda.service.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	public Agenda findById(Integer id) {
		Optional<Agenda> obj = agendaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado ID:" + id + " Tipo:" + Agenda.class.getName()));
	}

	public List<Agenda> finidAllOpen() {
		List<Agenda> list = agendaRepository.findAllOpen();
		return list;
	}

	public List<Agenda> finidAllClose() {
		List<Agenda> list = agendaRepository.findAllClose();
		return list;
	}

	public List<Agenda> findAll() {
		List<Agenda> list = agendaRepository.findAll();
		return list;
	}

	public Agenda create(Agenda obj) {
		obj.setId(null);
		return agendaRepository.save(obj);
	}

	public void delete(Integer id) {
		agendaRepository.deleteById(id);
	}

	public Agenda update(Integer id, Agenda obj) {
		Agenda newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return agendaRepository.save(newObj);
	}

}
