package bossmonster.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return readLine();
        }
    }
}
