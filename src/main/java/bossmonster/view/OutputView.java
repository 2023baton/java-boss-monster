package bossmonster.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private void println(String text) {
        try {
            bw.write(text + "\n");
            bw.flush();
        } catch (IOException e) {
            text = null;
        }
    }

    public void printMessage(String message) {
        println(message);
    }
}
