package mathcalc;

import java.util.List;

public class Calculation {

    String functionName;
    private List<String> input;
    private List<String> output;

    public Calculation(List<String> input, List<String> output, String function) {
        this.functionName = function;
        this.input = input;
        this.output = output;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }
    public List<String> getOutput() {
        return output;
    }
    public void setOutput(List<String> output) {
        this.output = output;
    }
    public String getFunctionName() {
        return functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String toString(){
        return "" + this.output + "";
    }
}
