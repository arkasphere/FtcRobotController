package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@Disabled
@TeleOp
public class MecDriveOpMode extends OpMode {


    MecanumDrive mecDrive = new MecanumDrive();
    double forward, strafe, yaw;
    boolean fieldRelativeDrive = gamepad1.right_trigger > 0.1;

    @Override
    public void init() {
        mecDrive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y * -1.0;
        strafe = gamepad1.left_stick_x;
        yaw = gamepad1.right_stick_x;
        fieldRelativeDrive = gamepad1.y;
        }
    }

