package pro.sky.telegrambot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "notification_task")
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "chad_id")
    private Long chadId;
    @Column(name = "message_text")
    private String messageText;
    @Column(name = "time_and_date")
    private LocalDateTime localDateTime;

    public NotificationTask() {
    }

    public NotificationTask(Long id, Long chadId, String messageText, LocalDateTime localDateTime) {
        this.id = id;
        this.chadId = chadId;
        this.messageText = messageText;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChadId() {
        return chadId;
    }

    public void setChadId(Long chadId) {
        this.chadId = chadId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return Objects.equals(id, that.id) && Objects.equals(chadId, that.chadId) && Objects.equals(messageText, that.messageText) && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chadId, messageText, localDateTime);
    }

    @Override
    public String toString() {
        return "NotificationTask{" +
                "id=" + id +
                ", chadId=" + chadId +
                ", messageText='" + messageText + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
