package com.daypaytechnologies.smiletool.commands.handlers;

import com.daypaytechnologies.smiletool.commands.dto.URLResourceResultBodyCommandDTO;
import com.daypaytechnologies.smiletool.core.OnDataTransferListener;
import com.daypaytechnologies.smiletool.core.PanelRegistry;
import com.daypaytechnologies.smiletool.core.commands.Command;
import com.daypaytechnologies.smiletool.core.commands.CommandType;
import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;
import org.springframework.stereotype.Service;

@Service
@CommandType("URLResourceResultBodyCommandHandler")
public class URLResourceResultBodyCommandHandler implements Command {

    @Override
    public void execute(CommandDTO commandDTO) {
        URLResourceResultBodyCommandDTO URLResourceResultBodyCommandDTO = (URLResourceResultBodyCommandDTO) commandDTO;
        OnDataTransferListener urlResourceResultBodyPanel = (OnDataTransferListener) PanelRegistry.get("urlResourceResultBodyPanel");
        urlResourceResultBodyPanel.onHandleResult(URLResourceResultBodyCommandDTO);
    }
}
