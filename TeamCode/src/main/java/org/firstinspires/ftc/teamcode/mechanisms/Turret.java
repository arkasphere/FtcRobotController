package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Turret {
    private Servo servoPos;
    private IMU imu;

    public void init(HardwareMap  hwMap) {
        servoPos = hwMap.get(Servo.class, "servo");
        imu = hwMap.get(IMU.class, "imu");
        servoPos.setDirection(Servo.Direction.FORWARD);
    }
    public void setServoPos (double hivePos) {
        double yaw = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        double target = yaw - (hivePos-180);
        servoPos.setPosition(ServoAngle.convert(target));
    }
}
