package spring_lection_2.Model;

public class ResponseDTO {
    private int sum;
    private String data;

    public String getData() {
        return data;
    }
    public int getSum() {
        return sum;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}
