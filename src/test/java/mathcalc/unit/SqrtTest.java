package mathcalc.unit;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import mathcalc.CalculationController;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(DataProviderRunner.class)
public class SqrtTest {

    private CalculationController calculationController;

    @DataProvider
    public static Object[][] valuesForSqrt() {
        return new Object[][]{
                {"64", "8.0"},
                {"16", "4.0"},
                {"0", "0.0"},
        };
    }

    @Test
    @UseDataProvider("valuesForSqrt")
    public void shouldReturnProperValuesFromSqrtCalculation(String input, String expected){
        calculationController = new CalculationController();
        String output = String.valueOf(calculationController.sqrt(input));

        assertThat(output, containsString(expected));
    }

    @Test
    public void shouldReturnMessageWhenStringPassed(){
        calculationController = new CalculationController();
        String output = String.valueOf(calculationController.sqrt("dfs"));

        assertThat(output, containsString("Input value is not set to numeric value."));
    }

}
