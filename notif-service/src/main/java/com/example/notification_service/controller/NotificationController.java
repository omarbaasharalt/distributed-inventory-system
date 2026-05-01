package com.example.notification_service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.notification_service.model.Notification;
// Import must match the class name with the underscore
import com.example.notification_service.service.Notification_Service;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    // Variable type must match the class name Notification_Service
    private final Notification_Service notificationService;

    // Constructor parameter must also match the class name
    public NotificationController(Notification_Service notificationService) {
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