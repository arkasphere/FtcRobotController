package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;


@TeleOp
public class MecDriveOpMode extends OpMode {


    MecanumDrive drive = new MecanumDrive();
    double forward, strafe, yaw, maxSpeed;
    boolean fieldRelativeDrive = gamepad1.right_trigger > 0.1;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y * -1.0;
        strafe = gamepad1.left_stick_x;
        yaw = gamepad1.right_stick_x;
        fieldRelativeDrive = gamepad1.y;
        maxSpeed = 1.0;

        if (fieldRelativeDrive) {
            drive.driveFieldRelative(forward, strafe, yaw, maxSpeed);
        }
    }
}

