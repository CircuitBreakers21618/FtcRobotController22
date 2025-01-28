package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "SP speciman", group = "2024-25 SP")
public class specimonauto extends LinearOpMode {

    Drive2 driveAuto = new Drive2();
    LineraMecanizme LineraMecanizmeteleop = new LineraMecanizme();

    double forwardSpeed = 0.5;
    double backwardSpeed = -0.5;

    int startTime = 700;
    int startTime2 = 700;
    int backwardTime = 600;
    int strafe = 4000;

    int sleepTime3 = 300;
    int sleepTime2 = 1500;
    int sleepTime = 50;
    int sleepLift = 700;
    @Override
    public void runOpMode() throws InterruptedException {

        driveAuto.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);
        waitForStart();
        driveAuto.moveforward(forwardSpeed, startTime);
        driveAuto.stopmotor();
        sleep(sleepTime);
        LineraMecanizmeteleop.leftliner.setPower(-.64);
        sleep(sleepLift);
        driveAuto.moveforward(forwardSpeed, startTime2);
        driveAuto.stopmotor();
        sleep(sleepTime);
        LineraMecanizmeteleop.leftliner.setPower(.5);
        sleep(sleepTime3);
        LineraMecanizmeteleop.claw.setPosition(.8);
        sleep(sleepTime2);
        LineraMecanizmeteleop.stopmotor2();
        driveAuto.moveforward(backwardSpeed, backwardTime);
        driveAuto.stopmotor();
        driveAuto.strafe(forwardSpeed, strafe);
        driveAuto.stopmotor();
        sleep(sleepTime);

    }
}
