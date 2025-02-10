package servicos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Consulta;
import entidades.Medico;
import excecoes.ConsultaJaExisteException;
import excecoes.ConsultaNaoEncontradaException;

public class ServicoConsulta {
    private List<Consulta> consultas;

    public ServicoConsulta() {
        this.consultas = new ArrayList<>();
    }

    // Agendar uma nova consulta
    public void agendarConsulta(Consulta consulta) throws ConsultaJaExisteException {
        if (buscarConsulta(consulta.getDataConsulta(), consulta.getHorarioInicio(), consulta.getMedico()) != null) {
            throw new ConsultaJaExisteException("Já existe uma consulta marcada para esse horário com este médico.");
        }
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    // Listar todas as consultas
    public List<Consulta> listarConsultas() {
        return consultas;
    }

    // Listar consultas por paciente
    public List<Consulta> listarConsultasPorPaciente(String cpfPaciente) {
        return consultas.stream()
                .filter(c -> c.getPaciente().getCpf().equals(cpfPaciente))
                .collect(Collectors.toList());
    }

    // Atualizar uma consulta
    public void atualizarConsulta(LocalDate dataAntiga, LocalTime horarioAntigo, Medico medico, Consulta novaConsulta)
            throws ConsultaNaoEncontradaException {
        Consulta consultaExistente = buscarConsulta(dataAntiga, horarioAntigo, medico);
        if (consultaExistente == null) {
            throw new ConsultaNaoEncontradaException("Consulta não encontrada.");
        }

        // Atualizando os atributos da consulta
        consultaExistente.setDataConsulta(novaConsulta.getDataConsulta());
        consultaExistente.setHorarioInicio(novaConsulta.getHorarioInicio());
        consultaExistente.setDuracao(novaConsulta.getDuracao());
        consultaExistente.setStatus(novaConsulta.getStatus());
        consultaExistente.setPaciente(novaConsulta.getPaciente());
        consultaExistente.setMedico(novaConsulta.getMedico());
        consultaExistente.setExamesPrescritos(novaConsulta.getExamesPrescritos());
        consultaExistente.setMedicamentosPrescritos(novaConsulta.getMedicamentosPrescritos());
        consultaExistente.setValor(novaConsulta.getValor());

        System.out.println("Consulta atualizada com sucesso!");
    }

    // Cancelar uma consulta
    public void cancelarConsulta(LocalDate data, LocalTime horario, Medico medico) throws ConsultaNaoEncontradaException {
        Consulta consulta = buscarConsulta(data, horario, medico);
        if (consulta == null) {
            throw new ConsultaNaoEncontradaException("Consulta não encontrada.");
        }

        consultas.remove(consulta);
        System.out.println("Consulta cancelada com sucesso!");
    }

    // Remover uma consulta
    public void removerConsulta(LocalDate data, LocalTime horario, Medico medico) throws ConsultaNaoEncontradaException {
        Consulta consulta = buscarConsulta(data, horario, medico);
        if (consulta == null) {
            throw new ConsultaNaoEncontradaException("Consulta não encontrada.");
        }

        consultas.remove(consulta);
        System.out.println("Consulta removida com sucesso!");
    }

    // Buscar uma consulta específica
    private Consulta buscarConsulta(LocalDate data, LocalTime horario, Medico medico) {
        for (Consulta c : consultas) {
            if (c.getDataConsulta().equals(data) && c.getHorarioInicio().equals(horario) && c.getMedico().equals(medico)) {
                return c;
            }
        }
        return null;
    }
}
