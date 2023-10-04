package spring_lection_2.Controllers;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;
import spring_lection_2.Services.MainService;

@Controller
@RequestMapping("/app")
public class Controllers {
    
    @Autowired
    private ApplicationContext context;

    @Autowired
    private MainService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestBody RequestDTO user){
        return service.add(user);
    }
    @GetMapping(value = "/find",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findData(@RequestParam Integer id){
        return service.find(id);
    }
    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateData(@RequestParam Integer id,@RequestBody RequestDTO info){
        return service.update(id, info);
    }

    @DeleteMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO deleteData(@RequestParam Integer id){
        return service.delete(id);
    }

    
    @GetMapping("/stop")
    public void stopService(){
        ((ConfigurableApplicationContext) context).close();
    }
    @PreDestroy
    public void stop(){

    }
    @PostConstruct
    public void start(){

    }
}
