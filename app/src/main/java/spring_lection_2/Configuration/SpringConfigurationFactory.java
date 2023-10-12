package spring_lection_2.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring_lection_2.Controllers.Main_Controller;
import spring_lection_2.Controllers.Side_Controller;
import spring_lection_2.Services.MainService;
import spring_lection_2.Services.SideService;

@Configuration
public class SpringConfigurationFactory {
    
    @Bean(name = "MainService")
    @Scope(value = "prototype")
    public MainService mainServiceBean(){
        return new MainService();
    }

    @Bean(name = "SideService")
    public SideService sideServiceBean(){
        return new SideService();
    }
    @Bean(name = "Side_Controller")
    public Side_Controller side_ControllerBean(){
        Side_Controller controller = new Side_Controller();
        controller.setSideService(sideServiceBean());
        return controller;
    }
    @Bean(name = "Main_Controller")
    @Scope(value = "prototype")
    public Main_Controller controllerBean(){
        return new Main_Controller(mainServiceBean());
    }

    
}
