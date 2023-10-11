package spring_lection_2.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import spring_lection_2.Model.Exp;
import spring_lection_2.Model.Position;
import spring_lection_2.Model.RequestDTO;
import spring_lection_2.Model.ResponseDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
    public void log(String type,ResponseDTO user){
        if (type == null || user == null) {
            throw new IllegalArgumentException();
        }
        byte[] data = ("\nType" + type + "\nName: " + user.getFirst_name() + " / " + user.getLast_name()).getBytes();
        try(FileOutputStream fileOutputStream = new FileOutputStream("log.dat",true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){



                byteArrayOutputStream.write(data);
                byteArrayOutputStream.writeTo(fileOutputStream);
                dataOutputStream.writeUTF("\nID: " + user.getId());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setPosition(ResponseDTO user,RequestDTO info){
        int max = Collections.max(info.getExpirience(),rule).getValue();
        switch(max){
            case 50:
                user.setPosition(Position.JUNIOR);
                break;
            case 70:
                user.setPosition(Position.MIDDLE); 
                break;
            case 90:
                user.setPosition(Position.SENIOR);
                break;
            case 100:
                user.setPosition(Position.LEAD);    
                break;      

        }
    }
    public ResponseDTO add(RequestDTO info){
        ResponseDTO user = new ResponseDTO();
        user.setLast_name(info.getLast_name());
        user.setFirst_name(info.getFirst_name());
        user.setId(info.getId());
        user.setFirst_tool("First tool: " + info.getTool().getFirst());
        user.setSecond_tool("Second tool: " + info.getTool().getSecond());
        user.setCar(info.getCar());
        setPosition(user, info);
        database.add(user);
        log("Created: ", user);
        return user;
    }
    public ResponseDTO find(Integer id){
        for(ResponseDTO x: database){
            if(x.getId().equals(id)){
                log("Searched: ",x);
                return x;
            }
        }
        return null;
    }
    public ResponseDTO update(Integer id, RequestDTO info){
        ResponseDTO searchUser = find(id);
        if(searchUser != null){
            log("Before Update:", searchUser);
            searchUser.setFirst_name(info.getFirst_name());
            searchUser.setLast_name(info.getLast_name());
            searchUser.setId(info.getId());
            searchUser.setFirst_tool("First tool: " + info.getTool().getFirst());
            searchUser.setSecond_tool("Second tool: " + info.getTool().getSecond());
            searchUser.setCar(info.getCar());
            setPosition(searchUser, info);
            log("Updated: ", searchUser);
            return searchUser;
        }
        return null;
    }

    public ResponseDTO delete(Integer id){
        int index = -1;
        for(int i = 0; i < database.size();i++){
            if(database.get(i).getId().equals(id)){
                log("Deleted: ", database.get(i));
                index = i;
            }
        }
        if(index != -1){

            return database.remove(index);
            
        }
        return null;
    }
}
