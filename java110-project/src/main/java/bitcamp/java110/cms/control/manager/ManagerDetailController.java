package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {
    
    @RequestMapping("manager/detail")
    public void detailManager(Scanner keyIn) {
        System.out.print("조회할 매니저의 이메일? ");
        String email = keyIn.nextLine();
        Manager m = App.managerDao.findByEmail(email);
        
        if(m==null) {
            System.out.println("해당 이메일의 매니저 정보가 없습니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("암호: %s\n", m.getPassword());
        System.out.printf("직위: %s\n", m.getPosition());
        System.out.printf("전화: %s\n", m.getTel());
    }

}
