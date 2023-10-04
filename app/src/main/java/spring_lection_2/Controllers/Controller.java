package spring_lection_2.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;
import spring_lection_2.Services.MainService;

@RestController
@RequestMapping("/Test")
public class Controller {
    
    @Autowired
    private ApplicationContext context;

    @Autowired
    private MainService service;

    @RequestMapping(value = "/get",method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO getData(@RequestBody RequestDTO user){
        return service.first(user);
    }
    
    @GetMapping("/stop")
    public void stopService(){
        ((ConfigurableApplicationContext) context).close();
    }
}
