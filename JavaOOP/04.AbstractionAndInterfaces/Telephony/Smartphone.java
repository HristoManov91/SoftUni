package Telephony;

import java.util.List;

public class Smartphone implements Browsable , Callable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone (List<String> numbers , List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(isValidUrl(url)){
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private static boolean isValidUrl(String url) {
        char[] arr = url.toCharArray();
        for (char symbol : arr) {
            if (Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (isValidNumber(number)){
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private static boolean isValidNumber(String inputNumber) {
        char[] arr = inputNumber.toCharArray();
        for (char symbol : arr) {
            if (Character.isAlphabetic(symbol)){
                return false;
            }
        }
        return true;
    }
}
