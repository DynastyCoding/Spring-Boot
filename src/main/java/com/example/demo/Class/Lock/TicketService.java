package com.example.demo.Class.Lock;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Transactional
    public boolean buyTicket(String ticketId){
        Optional<Ticket> opt = ticketDao.findById(ticketId);
        if (opt.isEmpty()) return false;

        Ticket ticket = opt.get();
        if (ticket.getRemain() <= 0) return false;
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        ticket.setRemain(ticket.getRemain() - 1);
        ticketDao.save(ticket);
        return true;
    }
}