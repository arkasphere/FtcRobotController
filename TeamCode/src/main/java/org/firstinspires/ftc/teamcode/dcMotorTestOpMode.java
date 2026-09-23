package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanisms.dcMotorTest;

@TeleOp
public class dcMotorTestOpMode extends OpMode {
    dcMotorTest move = new dcMotorTest();
    double speed;
    @Override
    public void init() {move.init(hardwareMap);
    }

    @Override
    public void loop() {
        speed = gamepad1.left_stick_y;
        move.move(speed);
        telemetry.addData("speed", speed);

    }

}

