package za.ac.nwu.account.translator.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration

public class TranslatorConfig {

}
