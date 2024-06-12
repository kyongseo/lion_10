package hello.todoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }

    /**
     * AWS 클라우드 환경 및 온프레미스 환경에서 시스템 관리를 자동화하고, 제어하며, 효율적으로 운영할 수 있도록 도와주는 서비스
     * Parameter Store -->  애플리케이션 구성 데이터를 중앙에서 관리하고 보호할 수 있는 완전 관리형 서비스
     * SsmClient 는 AWS SSM Parameter Store와 상호 작용하는 클라이언트
     * GetParameterRequest 객체를 생성하여 Parameter Store에서 특정 매개 변수 요청합
     * name 메서드에 요청할 파라미터 이름을 지정하고, withDecryption(true) 를 설정하여 암호화된 값이 있는 경우 이를 복호화
     */
    @Bean
    public CommandLineRunner run(){
        return args -> {
            String region = "ap-northeast-2";

            SsmClient ssm = SsmClient.builder()
                    .region(Region.of(region))
                    .build();

            System.out.println("todo_DB_USERNAME:::" + getParameterValue(ssm,"/todo/config/DB_USERNAME"));
            System.out.println("todo_DB_PASSWORD:::" + getParameterValue(ssm,"/todo/config/DB_PASSWORD"));

        };
    }

    private String getParameterValue(SsmClient ssm, String parameterName) {
        GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(parameterName)
                .withDecryption(true)
                .build();

        GetParameterResponse parameterResponse = ssm.getParameter(parameterRequest);
        return parameterResponse.parameter().value();
    }
}
