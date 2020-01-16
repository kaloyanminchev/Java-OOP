package trafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight[] inputLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);

        int n = scanner.nextInt();
        TrafficLight[] trafficLights = TrafficLight.values();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            for (int i = 0; i < inputLights.length; i++) {
                int index = (inputLights[i].ordinal() + 1) % trafficLights.length;
                inputLights[i] = trafficLights[index];
                sb.append(inputLights[i]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
