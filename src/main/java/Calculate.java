import org.json.JSONObject;

public interface Calculate {
    default int multiply(int num1, int num2) {
        return num1 * num2;
    }

    default int sum(int num1, int num2) {
        return num1 + num2;
    }
    default int subtract(int num1, int num2) {
        return num1 - num2;
    }

    default int divide(int num1, int num2) {
        return num1 / num2;
    }


    default double simpleInterest(double value, double interestRate, int time) {
        return value * interestRate * time;
    }

    default double compoundInterest(double value, double interestRate, int time) {
        return value * Math.pow(1+interestRate,time);
    }

    default String returnOnCDI(double value) throws APIConn.APIException {
        double result;
        APIConn apiConn = new APIConn();
        JSONObject taxaInfo = apiConn.getRate("CDI");
        result = value * (taxaInfo.getDouble("valor")/100);
        return "The return on your investment of: $" + value + " was: $" + result;
    }
}
