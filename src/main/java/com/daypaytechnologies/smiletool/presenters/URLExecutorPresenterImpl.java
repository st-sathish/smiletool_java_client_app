package com.daypaytechnologies.smiletool.presenters;

import com.daypaytechnologies.smiletool.commands.dto.URLResourceResultBodyCommandDTO;
import com.daypaytechnologies.smiletool.core.commands.CommandInvoker;
import com.daypaytechnologies.smiletool.core.rmi.RmiServiceFactory;
import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;
import com.daypaytechnologies.smiletool.executions.rmi.RestRmiExecutorService;
import com.daypaytechnologies.smiletool.presenters.listeners.URLExecutorListener;
import org.springframework.stereotype.Service;

@Service
public class URLExecutorPresenterImpl extends AbstractURLExecutorPresenter implements URLExecutorPresenter {

    private final CommandInvoker commandInvoker;

    public URLExecutorPresenterImpl(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    @Override
    public void execute(URLExecutorListener listener, RestRequestDTO restRequestDTO) {
        try {
            RestRmiExecutorService restRmiExecutorService = RmiServiceFactory.getInstance().getRestRmiExecutorService();
            restRequestDTO.setRestURL("http://localhost:9090/accounts");
            restRequestDTO.setHttpMethod("GET");
            String result = restRmiExecutorService.execute(restRequestDTO);
            dispatchSuccessResult(result);
        } catch (Exception ex) {
            dispatchFailureResult("");
        }
        listener.onExecutionCompleted();
    }

    private void dispatchSuccessResult(String result) {
        URLResourceResultBodyCommandDTO dto = new URLResourceResultBodyCommandDTO();
        dto.setResult(result);
        commandInvoker.run(dto);
    }

    private void dispatchFailureResult(String result) {
        URLResourceResultBodyCommandDTO dto = new URLResourceResultBodyCommandDTO();
        dto.setResult(result);
        commandInvoker.run(dto);
    }
}
