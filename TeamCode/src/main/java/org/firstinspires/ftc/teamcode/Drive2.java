package org.firstinspires.ftc.teamcode;

import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection.FORWARD;
import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection.UP;
import static java.lang.Thread.sleep;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Drive2 {

    public DcMotor topleft;
    public DcMotor topright;
    public DcMotor backleft;
    public DcMotor backright;
    IMU imu;


    boolean orientationIsValid = true;
    YawPitchRollAngles robotOrientation;

    double abc;

    boolean justChangedLogoDirection = false;
    boolean justChangedUsbDirection = false;
    RevHubOrientationOnRobot.LogoFacingDirection[] logoFacingDirections
            = RevHubOrientationOnRobot.LogoFacingDirection.values();
    static RevHubOrientationOnRobot.UsbFacingDirection[] usbFacingDirections
            = RevHubOrientationOnRobot.UsbFacingDirection.values();
    int LAST_DIRECTION = logoFacingDirections.length - 1;
    static float TRIGGER_THRESHOLD = 0.2f;






    public void init(HardwareMap hwMap){

        topleft = hwMap.get(DcMotor.class, "topleft");
        topright = hwMap.get(DcMotor.class, "topright");
        backleft = hwMap.get(DcMotor.class, "backleft");
        backright = hwMap.get(DcMotor.class, "backright");
        imu = hwMap.get(IMU.class, "imu");



    }




    public void reset() throws InterruptedException {
        updateOrientation();
        imu.resetYaw();
    }

    public void strafe(double power, long time) throws InterruptedException {
        backleft.setPower(-power);
        backright.setPower(power);
        topleft.setPower(-power);
        topright.setPower(power);
        //how long it waits
        sleep(time);

    }

    public void LeftTurn(double power, double time) throws InterruptedException {
        backleft.setPower(power);
        backright.setPower(-power);
        topleft.setPower(-power);
        topright.setPower(power);
        //how long it waits
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        AngularVelocity angularVelocity = imu.getRobotAngularVelocity(AngleUnit.DEGREES);
        abc = orientation.getPitch(AngleUnit.DEGREES);
        if (abc < time){
            stopmotor();
        } else {
            LeftTurn(power, time);
        }}


    public void RightTurn(double power, double time) throws InterruptedException {
        backleft.setPower(-power);
        backright.setPower(power);
        topleft.setPower(power);
        topright.setPower(-power);
        //how long it waits
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        AngularVelocity angularVelocity = imu.getRobotAngularVelocity(AngleUnit.DEGREES);
        abc = orientation.getYaw(AngleUnit.DEGREES);
        if (abc < time){
            stopmotor();
        } else {
            RightTurn(power, time);
        }}
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
    void updateOrientation() {
        RevHubOrientationOnRobot.LogoFacingDirection logo = FORWARD;
        RevHubOrientationOnRobot.UsbFacingDirection usb = UP;
        try {
            RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logo, usb);
            imu.initialize(new IMU.Parameters(orientationOnRobot));
            orientationIsValid = true;
        } catch (IllegalArgumentException e) {
            orientationIsValid = false;
        }
    }
}
