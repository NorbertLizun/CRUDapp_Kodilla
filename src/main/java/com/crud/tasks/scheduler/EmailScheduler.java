package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "Tasks: Once a day email";


    private String tasksOrTaskCheck() {
        if (taskRepository.count() == 1) {
            return "task";
        } else {
            return "tasks";
        }
    }

    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "",
                        null
                )
        );
    }
}
