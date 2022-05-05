package realization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import realization.service.BankService;

@SpringBootApplication
/*@ComponentScan({"realization.controller", "realization.dto", "realization.model", "realization.repository", "realization.service"})*/
public class Runner {
    public static void main(String[] args) {
        /*SpringApplication.run(realization.Runner.class, args);*/
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(Runner.class, args);
        final BankService bankService= applicationContext.getBean(BankService.class);
        bankService.getText(3);



    }

}
