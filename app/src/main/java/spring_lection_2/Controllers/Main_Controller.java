package spring_lection_2.Controllers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;
import spring_lection_2.Services.MainService;


@RequestMapping("/main_app")
public class Main_Controller {
    
    @Autowired
    private ApplicationContext context;

    
    private MainService service;
    private final static Logger logger = LoggerFactory.getLogger(Main_Controller.class);

    public Main_Controller(MainService service){
        this.service = service;
    }


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestBody RequestDTO user){
        logger.info("https://192.168.0.106:8080/main/add: " + user);
        logger.info("Service: " + service);
        return service.add(user);
    }


    @GetMapping(value = "/find",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findData(@RequestParam Integer id){
        logger.info("https://192.168.0.106:8080/main/find: id = " + id);
        logger.info("Service: " + service);
        return service.find(id);
    }


    @PutMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateData(@RequestParam Integer id,@RequestBody RequestDTO info){
        logger.info("https://192.168.0.106:8080/main/update: id = " + id);
        logger.info("Body: " + info);
        logger.info("Service: " + service);
        return service.update(id, info);
    }

    @DeleteMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO deleteData(@RequestParam Integer id){
        logger.info("https://192.168.0.106:8080/main/delete: id = " + id);
        logger.info("Service: " + service);
        return service.delete(id);
    }

    
    @RequestMapping(value = "/stop",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void stopService(){
        ((ConfigurableApplicationContext) context).close();
    }
    @PostConstruct
    public void started(){
        logger.info("___APP WAS CREATED__");
    }
    @PreDestroy
    public void stopped(){
        logger.info("___APP WAS STOPPED___");
    }
}
