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
    int netzone = 1500;
    int firstBackwardTime = 700;
    int firstTurnTime = 1050;
    int howFarForward = 460;
    int secondTurnTime = 1125;
    int howFarSideways = 4350;
    int thirdTurnTime = 1000;
    int secondBackwardTime = 600;
    int linear = 440;

    int sleepTime = 10;
    int sleepArm = 1000;
    int sleepLift = 1000;

    @Override
    public void runOpMode() throws InterruptedException {

        //geting hardwareMap
        driveAuto.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);
        waitForStart();


        driveAuto.strafe(forwardSpeed, linear);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.LeftTurn(forwardSpeed, firstTurnTime);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.moveforward(forwardSpeed, netzone);
        driveAuto.stopmotor();
        sleep(sleepTime);
//        LineraMecanizmeteleop.leftliner.setPower(.5);
//        driveAuto.stopmotor();
//        sleep(sleepLift);
        driveAuto.moveforward(backwardSpeed, firstBackwardTime);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.LeftTurn(forwardSpeed, firstTurnTime);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.moveforward(forwardSpeed, howFarSideways);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.LeftTurn(forwardSpeed, thirdTurnTime);
        driveAuto.stopmotor();
        sleep(sleepTime);
        driveAuto.moveforward(backwardSpeed, secondBackwardTime);
        driveAuto.stopmotor();
        sleep(sleepTime);

        sleep(sleepArm);

    }

}











