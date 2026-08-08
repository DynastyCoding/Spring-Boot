package com.example.demo.Class.Lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets/{id}/buy")
    public ResponseEntity<String> buyTicket(@PathVariable("id") String id) {
        try {
            boolean success = ticketService.buyTicket(id);
            return success
                    ? ResponseEntity.ok("購票成功")
                    : ResponseEntity.status(400).body("已售完或票券不存在");
        } catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(409).body("搶購失敗，請重試");
        }
    }
}