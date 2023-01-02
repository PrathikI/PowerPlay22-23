package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.HardwareRobot;

// Driver A - controls DriveTrain and Intake Servo
// Driver B - controls Turn Table Motor and Servo
@TeleOp
public class TeleOpFirstComp extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException {

        HardwareRobot robot = new HardwareRobot();
        ElapsedTime timer = new ElapsedTime();
        MecanumDrive drive = new MecanumDrive(hardwareMap);


        robot.init(hardwareMap);

        waitForStart();


        if (isStopRequested()) return;


        while(opModeIsActive()) {
            // Update function for DriveTrain located in MecanumDrive
            drive.Update(gamepad1, gamepad2);
        }
    }
}