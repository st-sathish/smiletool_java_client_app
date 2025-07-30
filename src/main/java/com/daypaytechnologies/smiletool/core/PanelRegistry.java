package com.daypaytechnologies.smiletool.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PanelRegistry implements InitializingBean {

    private static final Map<String, Object> panelMap = new HashMap<>();

    private final ListableBeanFactory beanFactory;

    public PanelRegistry(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> rmiBeans = beanFactory.getBeansWithAnnotation(PanelComponent.class);
        rmiBeans.forEach((key, bean) -> {
            Class<?> clazz = bean.getClass();
            PanelComponent annotation = clazz.getAnnotation(PanelComponent.class);
            if (annotation != null) {
                String panelName = annotation.value();
                System.out.println("Bean name: " + key + ", PanelComponent value: " + panelName);
                panelMap.put(panelName, bean);
            }
        });
    }

    public static void register(String name, Object panel) {
        panelMap.put(name, panel);
    }

    public static Object get(String name) {
        return panelMap.get(name);
    }

    /*public static void scanAndRegister(Object... components) {
        for (Object comp : components) {
            Class<?> clazz = comp.getClass();
            if (clazz.isAnnotationPresent(PanelComponent.class)) {
                String name = clazz.getAnnotation(PanelComponent.class).value();
                register(name, comp);
            }
        }
    }*/
}
