package com.example.notification_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.notification_service.model.Notification;

@Service
public class NotificationService {

    private final List<Notification> notifications = new ArrayList<>();

    public Notification sendLowStockAlert(Notification notification) {
        notifications.add(notification);
        return notification;
    }

    public List<Notification> getAllNotifications() {
        return notifications;
    }
}