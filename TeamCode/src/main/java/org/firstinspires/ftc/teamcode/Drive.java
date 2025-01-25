 package org.firstinspires.ftc.teamcode;

 import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 import com.qualcomm.robotcore.hardware.Servo;


 @TeleOp(name ="teleop", group = "2024-25 SP")
//naming it
public class Drive extends OpMode {

    //calls instilization of motors and servos
    Drive2 driveteleop = new Drive2();
    LineraMecanizme LineraMecanizmeteleop = new LineraMecanizme();




    @Override
    public void init() {

        //calling hardwareMap
        driveteleop.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);


    }

    @Override
    public void loop() {
        //seting powers
        driveteleop.topleft.setPower(-gamepad1.left_stick_y / 1.1 + -gamepad1.right_stick_x * 1.1 + gamepad1.left_stick_x);
        driveteleop.backleft.setPower(gamepad1.left_stick_y / 1.1 + -gamepad1.right_stick_x * 1.1 -gamepad1.left_stick_x);
        driveteleop.topright.setPower(-gamepad1.left_stick_y * 1.1 + gamepad1.right_stick_x * 1.2 -gamepad1.left_stick_x);
        driveteleop.backright.setPower(gamepad1.left_stick_y * 1.1 + gamepad1.right_stick_x * 1.1 + gamepad1.left_stick_x);
        LineraMecanizmeteleop.leftliner.setPower(gamepad2.right_stick_y);

        LineraMecanizmeteleop.arm.setPower(gamepad2.left_stick_y);

        if (gamepad2.y){
            LineraMecanizmeteleop.claw.setPosition(.8);
            
        }

        if (gamepad2.a){
            LineraMecanizmeteleop.claw.setPosition(.425);

        }


        }
}