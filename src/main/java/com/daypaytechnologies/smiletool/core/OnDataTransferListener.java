package com.daypaytechnologies.smiletool.core;

import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;

public interface OnDataTransferListener {

    void onHandleResult(CommandDTO commandDTO);
}
