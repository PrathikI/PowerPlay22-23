package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

/*
 * This is a simple routine to test translational drive capabilities.
 */
@Config
@Autonomous
public class BlueTermRed extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        MecanumDrive drive = new MecanumDrive(hardwareMap);

        // Blue Terminal Red Alliance (A5 Start Position)
        // Start with Corner of the White Tape
        Trajectory preLoadMoveToPole = drive.trajectoryBuilder(new Pose2d())
                .lineToLinearHeading(new Pose2d(45, 0))
                // Add Temporal Marker to Lift Depositor and Turn TurnTable
                .build();

        // Set Motor Power to Depositor - Deposits Cone
        // Set Motor Power to 0 - Turns Depositor Off
        // Set turn table power on for # milliseconds

        Trajectory moveToStack = drive.trajectoryBuilder(preLoadMoveToPole.end())
                .lineToLinearHeading(new Pose2d(19, 0))
                .build();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectory(preLoadMoveToPole);
        drive.turn(Math.toRadians(-90));
        drive.followTrajectory(moveToStack);

        }
    }
