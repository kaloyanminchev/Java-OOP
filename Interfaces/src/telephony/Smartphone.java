package telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String num : this.numbers) {
            Matcher matcher = Pattern.compile("^(\\d+)$")
                    .matcher(num);

            if (matcher.find()) {
                sb.append("Calling... ").append(num);
            } else {
                sb.append("Invalid number!");
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            Matcher matcher = Pattern.compile("^(\\D+)$")
                    .matcher(url);

            if (matcher.find()) {
                sb.append("Browsing: ").append(url).append("!");
            } else {
                sb.append("Invalid URL!");
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
