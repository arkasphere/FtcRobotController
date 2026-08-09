package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotColorSensor {
    NormalizedColorSensor colorSensor;

    public enum DetectedColor {
        // Gatorade Bottle: R , G >
        UNKOWN
    }
    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensorColor");
        colorSensor.setGain(8);
    }
    public DetectedColor getDetectedColor(Telemetry tele) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        tele.addData("red", normRed);
        tele.addData("green", normGreen);
        tele.addData("blue", normBlue);

        //TODO add if statements for different colors.

        return DetectedColor.UNKOWN;
    }

}
