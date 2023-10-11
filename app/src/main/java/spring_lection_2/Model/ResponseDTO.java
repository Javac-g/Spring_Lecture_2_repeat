package spring_lection_2.Model;

import java.util.Objects;

public class ResponseDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private Position position;
    private String first_tool,second_tool;
    private Car car;

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public String getFirst_tool() {
        return first_tool;
    }
    
    public void setFirst_tool(String first_tool) {
        this.first_tool = first_tool;
    }
    public String getSecond_tool() {
        return second_tool;
    }
    public void setSecond_tool(String second_tool) {
        this.second_tool = second_tool;
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString(){
        return "\nName: " + first_name + " " + last_name + "\nID: " + id + "\nPosition: " + position;
    }
    @Override
    public boolean equals(Object ob){
        if(this == ob){
            return true;
        }
        if(ob == null || getClass() != ob.getClass()){
            return false;
        }
        ResponseDTO user = (ResponseDTO)ob;
        return Objects.equals(first_name, user.getFirst_name()) 
                    && Objects.equals(getLast_name(),user.getLast_name())
                    && Objects.equals(id, user.getId())
                    && Objects.equals(first_tool, user.getFirst_tool())
                    && Objects.equals(second_tool, user.getSecond_tool());
    }
    @Override
    public int hashCode(){
        int hash = 5;
        hash = hash * 3 + Objects.hashCode(first_name);
        hash = hash * 3 + Objects.hashCode(last_name);
        hash = hash * 3 + Objects.hashCode(id);
        hash = hash * 3 + Objects.hashCode(first_tool);
        hash = hash * 3 + Objects.hashCode(second_tool);
        return hash;
    }
}
