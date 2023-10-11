package spring_lection_2.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring_lection_2.Controllers.Main_Controller;
import spring_lection_2.Controllers.Side_Controller;
import spring_lection_2.Services.MainService;
import spring_lection_2.Services.SideService;

@Configuration
public class SpringConfigurationFactory {

    @Bean
    public MainService serviceBean(){
        return new MainService();
    }

    @Bean
    public SideService sideServiceBean(){
        return new SideService();
    }
    @Bean
    public Side_Controller side_ControllerBean(){
        Side_Controller controller = new Side_Controller();
        controller.setSideService(sideServiceBean());
        return controller;
    }
    @Bean
    public Main_Controller controllerBean(){
        Main_Controller main_Controller = new Main_Controller();
        main_Controller.setService(serviceBean());
        return main_Controller;
    }

    
}
