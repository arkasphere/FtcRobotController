package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

@TeleOp
public class FundamentOpMode extends OpMode {

//  mecanum dive mechanism
    MecanumDrive mecDrive = new MecanumDrive();
    double forward, strafe, yaw;

//   Turret
    Turret turret = new Turret();
    double hivePos;


    public void init() {
        mecDrive.init(hardwareMap);
        turret.init(hardwareMap);

    }
    public void init_loop() {

    }
    public void loop() {
//        Mecanum Drive
        forward = gamepad1.left_stick_y * -1;
        strafe = gamepad1.left_stick_x;
        yaw = gamepad1.right_stick_x;
        mecDrive.drive(forward, strafe, yaw, 1);

//       turret
        if (gamepad2.right_bumper) {
            hivePos = -90;
            telemetry.addData("hivePos", "right");
        }
        else if (gamepad2.left_bumper) {
            hivePos = 90;
            telemetry.addData("hivePos", "left");
        }
        turret.setServoPos(hivePos);
    }
}