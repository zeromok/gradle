package com.example.hello.ioc;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Log4j2
public class IocApplication {

        public static void main(String[] args) {
            SpringApplication.run(IocApplication.class, args);  // 스프링 어플리케이션이 실행이 되고 난 후

            ApplicationContext context = ApplicationProvider.getContext();  // context 가져오기

            String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";  // 인코딩 할 url

            // =========================
            // Base64 Encoding
            // =========================
//            Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//            Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//            Encoder encoder = new Encoder(base64Encoder);
//
//            String BaseResult = base64Encoder.encode(url);
//            log.info("BaseResult : {}", BaseResult);

            // =========================
            // URL Encoding
            // =========================
//            UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//            encoder.setMyEncoder(urlEncoder);
//
//            String UrlResult = encoder.encode(url);
//            log.info("UrlResult : {}", UrlResult);


            // =========================
            // Encoder
            // Encoder 안 코드 수정으로(@Qualifier) base, url 둘 다 쓸 수 있다.
            // =========================
            Encoder encoder = context.getBean(Encoder.class);
            String result = encoder.encode(url);
            log.info("result : {}", result);


        }// main

}// end class

//@Configuration  // 한 개의 클래스에서 여러 빈을 등록
// 코드 수정없이 여러 빈을 등록해 쓰려면 빈으로 하나씩 등록 = 주의) Encoder 컴포넌트 해제하기
//class AppConfig{
//
//    @Bean("base64")
//    public Encoder encoder(Base64Encoder base64Encoder){
//        return new Encoder(base64Encoder);
//    }
//
//    @Bean("url")
//    public Encoder encoder(UrlEncoder urlEncoder){
//        return new Encoder(urlEncoder);
//    }


// }

