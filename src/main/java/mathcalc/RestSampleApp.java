package mathcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestSampleApp {

    /**
     * Example uses:
     *
     * http://localhost:8181/calculation/sqrt/64
     * http://localhost:8181/calculation/power?base=2.09&exponent=4.5
     */
    public static void main(String[] args) {
        SpringApplication.run(RestSampleApp.class, args);
    }
}
