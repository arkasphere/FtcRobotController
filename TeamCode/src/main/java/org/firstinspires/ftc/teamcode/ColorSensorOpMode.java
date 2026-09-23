package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.mechanisms.RobotColorSensor;
@Disabled
@TeleOp
public class ColorSensorOpMode extends OpMode {

    RobotColorSensor robot = new  RobotColorSensor();
    @Override
    public void init() {
        robot.init(hardwareMap);
    }
    @Override
    public void loop() {
        robot.getDetectedColor(telemetry);
    }
}
