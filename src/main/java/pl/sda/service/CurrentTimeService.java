package pl.sda.service;

import java.time.LocalDateTime;

public class CurrentTimeService {
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
