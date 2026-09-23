package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {

    private DcMotor leftFront;
    private DcMotor leftRear;
    private DcMotor rightFront;
    private DcMotor rightRear;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        //initialize hwMap/bind to robot config
        leftFront = hwMap.get(DcMotor.class, "frontLeft");
        leftRear = hwMap.get(DcMotor.class, "backLeft");
        rightFront = hwMap.get(DcMotor.class, "frontRight");
        rightRear = hwMap.get(DcMotor.class, "backRight");

//      mirror motors
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

//      set motor stop type to brake
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//      run motors using encoder rather than setpos TO PREVENT COMPOUNDING SPEED!!!
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//      bind IMU/ set robot orientation
        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrient = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP);

        imu.initialize(new IMU.Parameters(RevOrient));
    }
    public void drive(double forward, double strafe, double yaw, double maxSpeed) {
        double leftFrontPower = forward + strafe + yaw;
        double leftRearPower = forward - strafe + yaw;
        double rightFrontPower = forward - strafe - yaw;
        double rightRearPower = forward + strafe - yaw;

        double maxPower = 1.0;

        maxPower = Math.max(maxPower, Math.abs(leftFrontPower));
        maxPower = Math.max(maxPower, Math.abs(leftRearPower));
        maxPower = Math.max(maxPower, Math.abs(rightFrontPower));
        maxPower = Math.max(maxPower, Math.abs(rightRearPower));

        leftFront.setPower(maxSpeed * leftFrontPower / maxPower);
        leftRear.setPower(maxSpeed * leftRearPower / maxPower);
        rightFront.setPower(maxSpeed * rightFrontPower / maxPower);
        rightRear.setPower(maxSpeed * rightRearPower / maxPower);
    }
    public void driveFieldRelative(double forward, double strafe, double yaw, double maxSpeed) {
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(forward, strafe);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, yaw, maxSpeed);
    }
}