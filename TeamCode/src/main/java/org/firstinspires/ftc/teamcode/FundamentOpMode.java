package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.ServoAngle;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;
import org.firstinspires.ftc.teamcode.mechanisms.dcMotorTest;

public class FundamentOpMode extends OpMode {

//  mecanum dive mechanism
    MecanumDrive mecDrive = new MecanumDrive();
    double forward, strafe, yaw;

//    Servo test mechanism
    Turret turret = new Turret();
    double hivePos;

//    DC motor mechanism
dcMotorTest motor = new dcMotorTest();
    double speed;

    public void init() {
        mecDrive.init(hardwareMap);
        turret.init(hardwareMap);
        motor.init(hardwareMap);

    }
    public void init_loop() {

    }
    public void loop() {
//        Mecanum Drive
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        yaw = gamepad1.right_stick_x;

//       turret
        if (gamepad2.right_bumper) {
            hivePos = 90;
            telemetry.addData("hivePos", "right");
        }
        else if (gamepad2.left_bumper) {
            hivePos = -90;
            telemetry.addData("hivePos", "left");
        }

//        DC motor
        speed = gamepad1.left_stick_y;
        motor.move(speed);
        telemetry.addData("speed", speed);
    }
}