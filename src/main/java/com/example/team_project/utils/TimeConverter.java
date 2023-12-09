package com.example.team_project.utils;

public class TimeConverter {
    public static String convertTime(int seconds) {
        int hours = seconds / 3600;
        int remainder = seconds - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;
        StringBuilder builder = new StringBuilder();
        if (hours != 0) {
            builder.append(hours + "시간 ");
        }
        if (mins != 0) {
            builder.append(mins + "분 ");
        }
        if (secs != 0) {
            builder.append(secs + "초");
        }
        if (builder.toString().length() == 0) {
            return "0초";
        }
        return builder.toString();
    }
}
