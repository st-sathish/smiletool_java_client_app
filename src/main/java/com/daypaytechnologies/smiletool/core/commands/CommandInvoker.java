package com.daypaytechnologies.smiletool.core.commands;

import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommandInvoker {

    private final ListableBeanFactory beanFactory;

    public CommandInvoker(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void run(CommandDTO dto) {
        try {
            Map<String, Object> rmiBeans = beanFactory.getBeansWithAnnotation(CommandType.class);
            rmiBeans.forEach((key, value) -> {
                if (dto.getCommandName().equals(key)) {
                    Command command = (Command) value;
                    command.execute(dto);
                }
            });
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getCause());
        }
    }
}
