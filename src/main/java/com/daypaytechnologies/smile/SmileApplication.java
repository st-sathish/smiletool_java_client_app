package com.daypaytechnologies.smile;

import com.daypaytechnologies.smile.ui.SmileFrameMainLauncher;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.awt.*;

@SpringBootApplication
public class SmileApplication {

    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(SmileApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        EventQueue.invokeLater(() -> {
            var ex = ctx.getBean(SmileFrameMainLauncher.class);
            ex.run();
        });
    }
}
