package spring_lection_2.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class Controller {
    
    @Autowired
    private ApplicationContext context;

    @GetMapping(value = "/g")
    public String getData(){
        return "Hello , you are here";
    }
    
    @GetMapping("/stop")
    public void stopService(){
        ((ConfigurableApplicationContext) context).close();
    }
}
