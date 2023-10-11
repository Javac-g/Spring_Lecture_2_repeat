package spring_lection_2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring_lection_2.Services.SideService;

@RequestMapping("/side")
public class Side_Controller {

    private SideService sideService;

    public void setSideService(SideService sideService) {
        this.sideService = sideService;
    }
    @GetMapping("/get")
    @ResponseBody
    public String getAnswer(){
        return sideService.getFirst();
    }
}
