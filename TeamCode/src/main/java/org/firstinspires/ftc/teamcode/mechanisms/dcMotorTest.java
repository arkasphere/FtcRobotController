package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class dcMotorTest {
    private DcMotor motor;;
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "dcMotor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
public void move(double speed) {
        motor.setPower(speed);
}
}