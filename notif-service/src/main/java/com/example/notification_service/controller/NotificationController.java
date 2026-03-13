package com.example.notification_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.notification_service.model.Notification;
import com.example.notification_service.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/low-stock")
    public Notification sendLowStock(@RequestBody Notification notification) {
        return notificationService.sendLowStockAlert(notification);
    }

    @GetMapping("/history")
    public List<Notification> getHistory() {
        return notificationService.getAllNotifications();
    }
}