package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class NotificationTaskService {
    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

    public List<NotificationTask> findByDate(LocalDateTime localDateTime) {
        return notificationTaskRepository.findByLocalDateTime(localDateTime);
    }

    public NotificationTask save(NotificationTask notificationTask) {
        return notificationTaskRepository.save(notificationTask);
    }

    public void delete(NotificationTask notificationTask) {
        notificationTaskRepository.delete(notificationTask);
    }
}
