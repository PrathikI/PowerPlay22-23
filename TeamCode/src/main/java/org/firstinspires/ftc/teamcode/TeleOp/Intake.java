package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.HardwareRobot;

// Driver A - controls DriveTrain and Intake Servo
// Driver B - controls Turn Table Motor and Servo
public class Intake {
    HardwareRobot robot;
    ElapsedTime time;

    public Intake(HardwareRobot r) {
        time = new ElapsedTime();

        robot = r;
    }

    public void Update(Gamepad gamepad1, Gamepad gamepad2, LinearOpMode linearOpMode) {

        // Intake Servo (Servo driving complant wheels)

        if (gamepad1.right_trigger > 0.1) {
            robot.intakeServo.setPower(0.3);
        }

        else if (gamepad1.left_trigger > 0.1) {
            robot.intakeServo.setPower(0.3);
        }

        else {
            robot.intakeServo.setPower(0.0);
        }


        // Turn Table Motor (Turns the Turn Table 180 degrees)



        // Turn Table Servo (Extends Four-Bar Mech Vertically)

        // High Stage
        if (gamepad2.y) {
            robot.frontServo.setPosition(0.2);
            robot.backServo.setPosition(0.2);
        }

        // Intake Stage
        else if (gamepad2.b) {
            robot.frontServo.setPosition(0.4);
            robot.backServo.setPosition(0.4);
        }

        // Low Stage
        else if (gamepad2.a) {
            robot.frontServo.setPosition(0.6);
            robot.backServo.setPosition(0.6);
        }

        // Medium Stage
        else if (gamepad2.x) {
            robot.frontServo.setPosition(0.8);
            robot.backServo.setPosition(0.8);
        }

    }
}
