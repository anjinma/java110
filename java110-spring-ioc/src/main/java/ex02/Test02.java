// IoC 컨테이너 :  자바의 classpath에서 설정 파일을 찾는 컨테이너
// => 스프링 컨테이너의 설정 정보는 XML 파일에 기롣한다.
// => OS의 파일 시스템에서 설정 파일을 찾는다.
//
// BeanFactory 인터페이스
//   | 
//  +--->ApplicationContext 인터페이스
//             |
//            +---> ClassPathXmlApplicationContext 클래스
//           |
//          +---> SystemXmlApplicationContext 클래스
//         |
//        +---> AnnotationConfigApplicationContext 클래스
//       |
//      +---> WebAllpicationContext 인터페이스 (웹 애플리케이션에서 사용)
//                      |
//                     +---> StaticWebApplicationContext 클래스
//                    |
//                   +---> XmlWebApplicationContext 클래스
//                  |
//                 +---> AnnotationConfigWebApplicationContext 클래스
package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // OS 파일 시스템 기준이다.
        // 이클립스에서 자바 클래스를 실행시키면,
        // 폴더에 현재 위치는 프로젝트 경로이다.
        // 따라서 다음 경로는 이 프로젝트 경로를 기준으로 찾는다.
        ApplicationContext iocContainer = 
                 new FileSystemXmlApplicationContext("src/main/java/ex02/app-context-1.xml");
        
    }
}
//// 클래스와 상관없이 어디 C: 이런곳에 있을 땐 이걸 써라!
//ClassPathXmlApplicationContext는 xml로 설정하는법
//AnnotationConfigApplicationContext는 클래스로 설정하는 것



