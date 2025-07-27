package com.daypaytechnologies.smiletool.presenters;

import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;
import com.daypaytechnologies.smiletool.presenters.listeners.URLExecutorListener;

public interface URLExecutorPresenter {

    void execute(URLExecutorListener listener, RestRequestDTO restRequestDTO);
}
