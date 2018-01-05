import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by USER on 2018/1/2.
 */

public class Tester {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        System.out.println(sdf.format(now));
        //反過來  有字串  德Date物件
        String s = "1998/06/06";
        try{
            Date birthday = sdf.parse(s);
            System.out.println(birthday);
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
