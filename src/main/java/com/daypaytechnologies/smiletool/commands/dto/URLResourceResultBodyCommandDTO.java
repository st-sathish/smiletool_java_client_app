package com.daypaytechnologies.smiletool.commands.dto;

import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;

public class URLResourceResultBodyCommandDTO extends CommandDTO {

    public String result;

    @Override
    public String getCommandName() {
        return "URLResourceResultBodyCommandHandler";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
