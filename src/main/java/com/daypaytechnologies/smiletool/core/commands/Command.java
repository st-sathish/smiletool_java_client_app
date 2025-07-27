package com.daypaytechnologies.smiletool.core.commands;

import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;

@FunctionalInterface
public interface Command {

    void execute(CommandDTO commandDTO);
}
