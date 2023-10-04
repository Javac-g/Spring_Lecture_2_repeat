package spring_lection_2.Services;

import org.springframework.stereotype.Service;

import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;

@Service
public class MainService {
    
    public ResponseDTO first(RequestDTO info){
        ResponseDTO user = new ResponseDTO();
        user.setSum(info.getA() + info.getB());
        user.setData(info.getData() + " setted");
        return user;
    }
}
