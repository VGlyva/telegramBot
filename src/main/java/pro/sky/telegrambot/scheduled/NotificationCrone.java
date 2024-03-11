package pro.sky.telegrambot.scheduled;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.repository.NotificationTaskRepository;
import pro.sky.telegrambot.service.NotificationTaskService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class NotificationCrone {
    private final NotificationTaskService notificationTaskService;
    private final TelegramBot telegramBot;

    public NotificationCrone(NotificationTaskService notificationTaskService, TelegramBot telegramBot) {
        this.notificationTaskService = notificationTaskService;
        this.telegramBot = telegramBot;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void task() {
        notificationTaskService.findByDate(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                .forEach(notificationTask -> {
                    telegramBot.execute(new SendMessage(notificationTask.getChadId(), notificationTask
                                    .getMessageText()));
                    notificationTaskService.delete(notificationTask);
                });
    }
}
