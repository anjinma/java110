//RequestMapping 다루기 
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test05 {
    
    // 특정 이름의 요청 헤더를 포함하고 있을 때만 호출되도록한다.
    // 테스트:
    // http://localhost:8888/app/ex02/Test05.html
    //
    @RequestMapping(value="/ex02/test05",
            headers="name")
    @ResponseBody
    public String m1() {
        return "ex02.Test05.m1()";
    }
    
    @RequestMapping(value="/ex02/test05",
            headers="age")
    @ResponseBody
    public String m2() {
        return "ex02.Test05.m2()";
    }
    
    @RequestMapping(value="/ex02/test05",
            headers= {"age","name"})
    @ResponseBody
    public String m3() {
        return "ex02.Test05.m3()";
    }
    
    @RequestMapping(value="/ex02/test05")
    @ResponseBody
    public String m4() {
        return "ex02.Test05.m4()";
    }
    
    
    
    
    
    
}
