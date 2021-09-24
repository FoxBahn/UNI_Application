package za.ac.nwu.account.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.account.web.sb.controller",
        "za.ac.nwu.account.web.sb.exception"
})
public class WebConfig {



}
