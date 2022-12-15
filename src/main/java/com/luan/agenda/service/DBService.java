package com.luan.agenda.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luan.agenda.domain.Agenda;
import com.luan.agenda.repositories.AgendaRepository;

@Service
public class DBService {

	@Autowired
	private AgendaRepository agendaRepository;

	public void instaciaBaseDeDados() throws ParseException {

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy
		// HH:mm");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Agenda a1 = new Agenda(null, "Estudar", "Estudar Inglês", sdf.parse("01/01/2023"), true);
		Agenda a2 = new Agenda(null, "Pet", "Levar Pet para passear", sdf.parse("01/01/2023"), false);
		Agenda a3 = new Agenda(null, "Cafe", "Tomar Café da manha", sdf.parse("01/01/2023"), true);
		Agenda a4 = new Agenda(null, "Estudar", "Estudar programacao", sdf.parse("01/01/2023"), false);
		Agenda a5 = new Agenda(null, "Treinar", "Ir a academia treinar", sdf.parse("01/01/2023"), false);
		// Agenda a5 = new Agenda(null, "Treinar", "Ir a academia treinar",
		// LocalDateTime.parse("01/01/2023 11:00", formatter), false);

		agendaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
	}

}
