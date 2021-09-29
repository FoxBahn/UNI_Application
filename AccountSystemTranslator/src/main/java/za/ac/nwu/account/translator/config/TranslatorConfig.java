package za.ac.nwu.account.translator.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration

@ComponentScan(basePackages = {
        "za.ac.nwu.account.translator"
})
public class TranslatorConfig {


}
