package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");


        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://norbertlizun.github.io./");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());

        context.setVariable("company_name", companyConfig.getCompanyName());
        context.setVariable("company_goal", companyConfig.getCompanyGoal());
        context.setVariable("company_email", companyConfig.getCompanyMail());
        context.setVariable("company_phone", companyConfig.getCompanyPhone());

        context.setVariable("goodbye_message", "Bye Bye!");
        context.setVariable("preview_message", "It's preview message");

        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);

        context.setVariable("admin_config", adminConfig);

        return templateEngine.process("created-trello-card-mail.html", context);
    }


    public String amountOfTasksDailyMail(String message) {


        long tasks = taskRepository.count();

        List<String> functionality = new ArrayList<>();
        functionality.add("F1");
        functionality.add("F2");
        functionality.add("F3");


        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://norbertlizun.github.io./");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());

        context.setVariable("company_name", companyConfig.getCompanyName());
        context.setVariable("company_goal", companyConfig.getCompanyGoal());
        context.setVariable("company_email", companyConfig.getCompanyMail());
        context.setVariable("company_phone", companyConfig.getCompanyPhone());

        context.setVariable("goodbye_message", "Bye Bye!");
        context.setVariable("preview_message", "It's preview message");

        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);

        context.setVariable("admin_config", adminConfig);

        context.setVariable("zero_tasks", "Create your first task");
        context.setVariable("more_than_zero_tasks", "Number of your task: " + tasks);

        if (tasks == 0) {
            context.setVariable("tasks", true);
        } else {
            context.setVariable("tasks", false);
        }

        return templateEngine.process("tasks-mail-amount.html", context);


    }

}
