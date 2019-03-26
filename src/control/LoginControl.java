package control;
import Dao.*;
import model.*;

public class LoginControl {

    public static void main(String [] args) {
        boolean f= check("123", "123");
        if(f==true)
        {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
    public static boolean check(String ps,String id)
    {
        System.out.println("到这了！");
        User tmp =LoginDb.queryById(id);

        if(tmp!=null&&ps.equals(tmp.getPassword()))
        {
            return true;
        }
        return false;
    }
}
