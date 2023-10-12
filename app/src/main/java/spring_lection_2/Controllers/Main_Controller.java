package spring_lection_2.Controllers;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;
import spring_lection_2.Services.MainService;


@RequestMapping("/main")
public class Main_Controller {
    
    @Autowired
    private ApplicationContext context;

    
    private MainService service;

    public Main_Controller(MainService service){
        this.service = service;
    }


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
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

    
    @RequestMapping(value = "/stop",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public void stopService(){
        ((ConfigurableApplicationContext) context).close();
    }
    
}
