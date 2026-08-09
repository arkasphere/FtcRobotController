package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.security.Policy;

public class Claw {

    private Servo claw;
    private ColorSensor cSensor;

    public void init(HardwareMap hwMap, Telemetry tele) {
        claw = hwMap.get(Servo.class, "servoClaw");
    }
}
