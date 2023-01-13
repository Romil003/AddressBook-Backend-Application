package com.bridgelabz.addressbookapplication.Config;

import com.bridgelabz.addressbookapplication.Util.JwtToken;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public JwtToken jwTtoken() {

        return new JwtToken();
    }

}
