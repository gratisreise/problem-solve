import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    public static void main(String[] args){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }
}