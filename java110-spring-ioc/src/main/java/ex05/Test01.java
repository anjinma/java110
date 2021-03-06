// setter 호출:
//
// XML 문법
//      <bean id="객체명 class="클래스명">
//          <property name="프로퍼티명" value="파라미터값">
//      </bean>

package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                 new ClassPathXmlApplicationContext("ex05/app-context-1.xml");
        System.out.println("-------------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 갯수 = %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name: names) {
            System.out.printf("=> %s: %s\n",name, iocContainer.getType(name).getName());
        }
        System.out.println("-------------------------------");
        
        
        
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        
        Car c2 = (Car)iocContainer.getBean("c2");
        System.out.println(c2);
        

        
    }
}
