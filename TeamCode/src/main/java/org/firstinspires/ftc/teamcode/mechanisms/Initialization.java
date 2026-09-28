package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcontroller.external.samples.externalhardware.RobotHardware;
public class Initialization {
    private IMU imu;

    public void init(HardwareMap hwMap) {
        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot RevOrient = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP);

        imu.initialize(new IMU.Parameters(RevOrient));
    }
}