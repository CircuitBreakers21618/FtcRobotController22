package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "highBasketAuto", group = "2024-25 SP")
public class highBasketAuto extends LinearOpMode {

    /*
Bryce
11/10/2024

This code is for starting spot number 2 and ending spot 1

Starting spot 2 is farthest from observation zone
ending spot 1 is closest to corner of field

Drives forward 11 mm
turns 90 degrees right
goes forward 245 mm
turns 90 left
goes backwards 11 mm
 */

    //calls instilization of motors and servos
    Drive2 driveAuto = new Drive2();
    LineraMecanizme LineraMecanizmeteleop = new LineraMecanizme();

    double forwardSpeed = .5;
    double backwardSpeed = -.5;

    //in milliseconds
    int linear = 30;
    int netzone = 250;
    int firstBackwardTime = 0;
    int linear2 = 500;

    int sleepTime = 500;
    int sleepTime2 = 1500;
    int sleepTime3 = 5000;

    int sleepLift = 1975;

    @Override
    public void runOpMode() throws InterruptedException {

        //geting hardwareMap
        driveAuto.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);
        waitForStart();


        driveAuto.strafe(forwardSpeed, linear);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.moveforward(forwardSpeed, netzone);
        driveAuto.stopmotor();
        sleep(sleepTime);
       LineraMecanizmeteleop.leftliner.setPower(-.64);
        sleep(sleepLift);
        driveAuto.moveforward(forwardSpeed, netzone);
        driveAuto.stopmotor();
        LineraMecanizmeteleop.leftliner.setPower(-.29);
        LineraMecanizmeteleop.claw.setPosition(.8);
        sleep(sleepTime2);
        driveAuto.strafe(forwardSpeed, linear2);
        driveAuto.stopmotor();
        LineraMecanizmeteleop.stopmotor2();
        sleep(sleepTime);
        driveAuto.moveforward(backwardSpeed, firstBackwardTime);
        sleep(sleepTime3);
        driveAuto.stopmotor();


    }

}











