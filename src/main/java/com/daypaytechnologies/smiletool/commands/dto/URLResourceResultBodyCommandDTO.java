package com.daypaytechnologies.smiletool.commands.dto;

import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class URLResourceResultBodyCommandDTO extends CommandDTO {

    public String result;

    @Override
    public String getCommandName() {
        return "URLResourceResultBodyCommandHandler";
    }
}
