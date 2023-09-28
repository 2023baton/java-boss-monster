package bossmonster.controller;

import java.util.Map;

public interface Controller {
    void process(Map<String, String> param, Map<String, Object> Model);
}
