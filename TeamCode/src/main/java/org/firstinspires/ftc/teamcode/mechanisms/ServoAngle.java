package org.firstinspires.ftc.teamcode.mechanisms;

public class ServoAngle {

    public static double convert(double input) {
        double out = input;
        if (input < 0) {
            out = 360 + input;
        }
        if (input > 300) {
            if (input <=330) {
                out = 360;
            }
            if (input <330) {
                out = 0;
            }
        }
        else {
            out = input;
        }
        return out;
    }

}
