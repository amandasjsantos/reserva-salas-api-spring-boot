package com.example.reserva.controller;

import com.example.reserva.model.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private List<Reserva> reservas = new ArrayList<>();

    public ReservaController() {
        reservas.add(new Reserva(1, "Daniel", "Sala A", "10/10/2026", "08:00", 10));
        reservas.add(new Reserva(2, "Amanda", "Sala B", "11/10/2026", "09:00", 15));
        reservas.add(new Reserva(3, "Renato", "Sala A", "12/10/2026", "10:00", 20));
        reservas.add(new Reserva(4, "Danilo", "Sala C", "13/10/2026", "14:00", 7));
        reservas.add(new Reserva(5, "Eduarda", "Sala B", "14/10/2026", "15:00", 25));
        reservas.add(new Reserva(6, "Bruna", "Sala D", "15/10/2026", "16:00", 12));
    }

    @PostMapping("/cadastrar-nova-reserva")
    public Reserva cadastrarNovaReserva(@RequestBody Reserva reserva) {
        reservas.add(reserva);
        return reserva;
    }

    @GetMapping("/todas-as-reservas-cadastradas")
    public List<Reserva> obterTodasReservasCadastradas() {
        return reservas;
    }

    @GetMapping("/codigo/{codigo}")
    public Reserva obterReservaPeloCodigo(@PathVariable int codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo() == codigo) {
                return reserva;
            }
        }
        return null;
    }

    @GetMapping("/sala/{sala}")
    public List<Reserva> obterSomenteReservasDeUmaDeterminadaSala(@PathVariable String sala) {
        List<Reserva> reservasSala = new ArrayList<>();

        for (Reserva reserva : reservas) {
            if (reserva.getSala().equalsIgnoreCase(sala)) {
                reservasSala.add(reserva);
            }
        }
        return reservasSala;
    }

    @GetMapping("/reserva-com-maior-quantidade-de-pessoas")
    public Reserva obterReservaComMaiorQtdPessoas() {
        if (reservas.isEmpty()) {
            return null;
        }

        Reserva maior = reservas.get(0);

        for (Reserva reserva : reservas) {
            if (reserva.getQtdPessoas() > maior.getQtdPessoas()) {
                maior = reserva;
            }
        }
        return maior;
    }

    @PutMapping("/{codigo}")
    public Reserva alterarDadosReservaCadastrada(@PathVariable int codigo, @RequestBody Reserva novaReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo() == codigo) {
                reserva.setNomeDoResponsavel(novaReserva.getNomeDoResponsavel());
                reserva.setSala(novaReserva.getSala());
                reserva.setData(novaReserva.getData());
                reserva.setHorario(novaReserva.getHorario());
                reserva.setQtdPessoas(novaReserva.getQtdPessoas());
                return reserva;
            }
        }
        return null;
    }

    @DeleteMapping("/{codigo}")
    public String excluirReservaPeloCodigo(@PathVariable int codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo() == codigo) {
                reservas.remove(reserva);
                return "Reserva excluída com sucesso!";
            }
        }
        return "Reserva não encontrada!";
    }
}
