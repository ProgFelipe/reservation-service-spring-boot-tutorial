/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.reservationservice.controllers;

import com.example.reservationservice.domain.Reservation;
import com.example.reservationservice.repositories.ReservationRepository;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author Felipe
 */
@Controller
public class ReservationRestController {
    private final ReservationRepository reservationRepository;

    ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservations")
    Collection<Reservation> reservations() {
        return reservationRepository.findAll();
    }
    
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("reservations", reservationRepository.findAll());
        return "index";
    }
}
