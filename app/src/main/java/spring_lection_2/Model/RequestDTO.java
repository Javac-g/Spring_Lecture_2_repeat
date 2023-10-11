package spring_lection_2.Model;
import java.util.*;

public class RequestDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private List<Exp> expirience = new ArrayList<>();
    private Tool tool;
    private Car car;
    public void setCar(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return car;
    }

    public Tool getTool() {
        return tool;
    }
    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getFirst_name() {
        return first_name;
    }
    public Integer getId() {
        return id;
    }
    public List<Exp> getExpirience() {
        return expirience;
    }
    public void setExpirience(List<Exp> expirience) {
        this.expirience = expirience;
    }

}
