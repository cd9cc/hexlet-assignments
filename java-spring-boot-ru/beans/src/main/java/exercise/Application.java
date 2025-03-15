package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @Scope("prototype")
    Daytime getDatetime() {
        var isDay = LocalTime.now().getHour() >= 6 && LocalTime.now().getHour() <= 22;
        if (isDay) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}
