package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive2 {

    public DcMotor topleft;
    public DcMotor topright;
    public DcMotor backleft;
    public DcMotor backright;

    public void init(HardwareMap hwMap){

        topleft = hwMap.get(DcMotor.class, "topleft");
        topright = hwMap.get(DcMotor.class, "topright");
        backleft = hwMap.get(DcMotor.class, "backleft");
        backright = hwMap.get(DcMotor.class, "backright");
    }

    public void RightTurn(double power, long time) throws InterruptedException {
        backleft.setPower(-power);
        backright.setPower(power);
        topleft.setPower(power);
        topright.setPower(-power);
        //how long it waits
        sleep(time);

    }
    public void strafe(double power, long time) throws InterruptedException {
        backleft.setPower(-power);
        backright.setPower(power);
        topleft.setPower(-power);
        topright.setPower(power);
        //how long it waits
        sleep(time);

    }

    public void LeftTurn(double power, long time) throws InterruptedException {
        backleft.setPower(power);
        backright.setPower(-power);
        topleft.setPower(-power);
        topright.setPower(power);
        //how long it waits
        sleep(time);

    }

    public void stopmotor(){
        backleft.setPower(0);
        backright.setPower(0);
        topleft.setPower(0);
        topright.setPower(0);

    }

    public void moveforward(double power, long time) throws InterruptedException {
        backleft.setPower(-power);
        backright.setPower(-power);
        topleft.setPower(power);
        topright.setPower(power);
        //how long it waits
        sleep(time);

    }
}
