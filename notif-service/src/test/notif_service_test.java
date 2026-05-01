package com.example.notification_service.service;

import com.example.notification_service.model.Notification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationServiceTest {

    private Notification_Service notificationService;

    @BeforeEach
    void setUp() {
        // Initialize the service before each test
        notificationService = new Notification_Service();
    }

    @Test
    void shouldStoreNotificationWhenSent() {
        // 1. Arrange: Create a fake notification
        Notification note = new Notification();
        note.setMessage("Low stock on Apple iPhone");

        // 2. Act: Send it through the service
        notificationService.sendLowStockAlert(note);

        // 3. Assert: Check if the list now contains exactly 1 item
        List<Notification> history = notificationService.getAllNotifications();
        
        assertThat(history).hasSize(1);
        assertThat(history.get(0).getMessage()).isEqualTo("Low stock on Apple iPhone");
    }

    @Test
    void shouldReturnEmptyListInitially() {
        // Verify the system starts with a clean slate
        assertThat(notificationService.getAllNotifications()).isEmpty();
    }
}