package spring_lection_2.Services;

import org.springframework.stereotype.Service;

import spring_lection_2.Model.RequestDTO;

@Service
public class MainService {
    
    public RequestDTO first(int a,int b,String data){
        RequestDTO user = new RequestDTO();
        user.setA(a + 10);
        user.setB(b + 20);
        user.setData( data + " setted");
        return user;
    }
}
