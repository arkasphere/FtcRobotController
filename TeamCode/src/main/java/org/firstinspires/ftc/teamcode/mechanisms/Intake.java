package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Intake {
    private DcMotor intake;
    public void init(HardwareMap hwMap){
        intake = hwMap.get(DcMotor.class, "intakeMotor");
    }
    public void setIntake(boolean spin){
        if(spin){intake.setPower(1.0);}
        else{intake.setPower(0.0);}
    }
}
