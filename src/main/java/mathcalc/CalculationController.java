package mathcalc;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

    private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";

    @RequestMapping("/power")
    public Calculation pow(@RequestParam(value = "base") String baseParam,
                           @RequestParam(value = "exponent") String exponentParam) {
        List<String> input = new ArrayList<String>();
        input.add(baseParam);
        input.add(exponentParam);
        List<String> output = new ArrayList();
        String powValue = "";
        if (baseParam != null && exponentParam != null && baseParam.matches(PATTERN) && exponentParam.matches(PATTERN)) {
            powValue = String.valueOf(Math.pow(Double.valueOf(baseParam),
                    Double.valueOf(exponentParam)));
        } else {
            powValue = "Base or/and Exponent is/are not set to numeric value.";
        }
        output.add(powValue);
        return new Calculation(input, output, "power");
    }

    @RequestMapping(value = "/sqrt/{value:.+}", method = RequestMethod.GET)
    public Calculation sqrt(@PathVariable(value = "value") String valueToSqrt) {
        List<String> input = new ArrayList();
        input.add(valueToSqrt);
        List<String> output = new ArrayList();
        String sqrtValue = "";
        if (valueToSqrt != null && valueToSqrt.matches(PATTERN)) {
            sqrtValue = String.valueOf(Math.sqrt(Double.valueOf(valueToSqrt)));
        } else {
            sqrtValue = "Input value is not set to numeric value.";
        }
        output.add(sqrtValue);
        return new Calculation(input, output, "sqrt");
    }
}
