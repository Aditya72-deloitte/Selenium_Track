package tests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class loginTest {
    String password = "secret_sauce";

    @Test
    void test1(){
        Main_automation auto = new Main_automation();
        String username1 = "standard_user";
        List<String> lst = new ArrayList<>();
        lst.add(username1);
        lst.add(password);
        auto.automate(lst);
    }

    @Test
    void test2(){
        Main_automation auto = new Main_automation();
        String username2 = "Locked_out_user";
        List<String> lst = new ArrayList<>();
        lst.add(username2);
        lst.add(password);
        auto.automate(lst);
    }

    @Test
    void test3(){
        Main_automation auto = new Main_automation();
        String username3 = "problem_user";
        List<String> lst = new ArrayList<>();
        lst.add(username3);
        lst.add(password);
        auto.automate(lst);
    }

    @Test
    void test4(){
        Main_automation auto = new Main_automaion();
        String username4 = "performance_glitch_user";
        List<String> lst = new ArrayList<>();
        lst.add(username4);
        lst.add(password);
        auto.automate(lst);
    }


}
