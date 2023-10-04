package spring_lection_2.Model;

public class ResponseDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private Position position;
    private Tool tool;

    public void setTool(Tool tool) {
        this.tool = tool;
    }
    public Tool getTool() {
        return tool;
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
}
