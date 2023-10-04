package spring_lection_2.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import spring_lection_2.Model.Exp;
import spring_lection_2.Model.Position;
import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;
import java.util.*;

@Service
public class MainService {
    private final List<ResponseDTO> database = new ArrayList<>();
    private Comparator<Exp> rule = new Comparator<>(){
        @Override
        public int compare(Exp a,Exp b){
            return Integer.compare(a.getValue(),b.getValue());
        }
    };
    public void setPosition(ResponseDTO user,RequestDTO info){
        int max = Collections.max(info.getExpirience(),rule).getValue();
        switch(max){
            case 50:
                user.setPosition(Position.JUNIOR);
            case 70:
                user.setPosition(Position.MIDDLE); 
            case 90:
                user.setPosition(Position.SENIOR);
            case 100:
                user.setPosition(Position.LEAD);          

        }
    }
    public ResponseDTO add(RequestDTO info){
        ResponseDTO user = new ResponseDTO();
        user.setLast_name(info.getLast_name());
        user.setFirst_name(info.getFirst_name());
        user.setId(info.getId());
        user.setTool(info.getTool());
        setPosition(user, info);
        database.add(user);
        return user;
    }
    public ResponseDTO find(Integer id){
        for(ResponseDTO x: database){
            if(x.getId().equals(id)){
                return x;
            }
        }
        return null;
    }
    public ResponseDTO update(Integer id, RequestDTO info){
        ResponseDTO searchUser = find(id);
        if(searchUser != null){
            searchUser.setFirst_name(info.getFirst_name());
            searchUser.setLast_name(info.getLast_name());
            searchUser.setId(info.getId());
            searchUser.setTool(info.getTool());
            setPosition(searchUser, info);
            return searchUser;
        }
        return null;
    }

    public ResponseDTO delete(Integer id){
        int index = -1;
        for(int i = 0; i < database.size();i++){
            if(database.get(i).getId().equals(id)){
                index = i;
            }
        }
        if(index != -1){
            return database.remove(index);
            
        }
        return null;
    }
}
