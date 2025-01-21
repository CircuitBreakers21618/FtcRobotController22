package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LineraMecanizme {
    public DcMotor arm2;
    public DcMotor leftliner;
    public Servo claw;
    public DcMotor arm;

    public void init(HardwareMap hwMap){
        arm2 = hwMap.get(DcMotor.class, "arm2");
        arm = hwMap.get(DcMotor.class, "arm");
        leftliner = hwMap.get(DcMotor.class, "leftliner");
        claw = hwMap.get(Servo.class, "claw");
        leftliner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftliner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftliner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);    }
}
