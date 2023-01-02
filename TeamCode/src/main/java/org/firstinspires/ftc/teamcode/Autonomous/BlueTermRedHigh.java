package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

/*
 * This is a simple routine to test translational drive capabilities.
 */
@Config
@Autonomous
public class BlueTermRedHigh extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        MecanumDrive drive = new MecanumDrive(hardwareMap);

        // Blue Terminal Red Alliance (A5 Start Position)
        // Start with Corner of the White Tape
        Pose2d startPose = new Pose2d(0, 0, 0);
        drive.setPoseEstimate(startPose);

        Trajectory preLoadMoveToPole = drive.trajectoryBuilder(startPose)
                .lineToLinearHeading(new Pose2d(44,0))
                // Add Temporal Marker to Lift Depositor and Turn TurnTable
                .build();

        // Set Motor Power to Depositor - Deposits Cone
        // Set Motor Power to 0 - Turns Depositor Off
        // Set Turn Table Power on for # milliseconds - Table Reset


        Trajectory moveToStack = drive.trajectoryBuilder(preLoadMoveToPole.end())
                .lineToLinearHeading(new Pose2d(44, -10, Math.toRadians(-91)))
                .build();

        Trajectory moveForward = drive.trajectoryBuilder(moveToStack.end())
                .lineToLinearHeading(new Pose2d(44, -35, Math.toRadians(-91)))
                .build();

        // Path for Park
        Trajectory moveBackward = drive.trajectoryBuilder(moveForward.end())
                .lineToLinearHeading(new Pose2d(44, -10, Math.toRadians(-91)))
                .build();

        Trajectory parking = drive.trajectoryBuilder(moveBackward.end())
                        .strafeLeft(22)
                        .build();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectory(preLoadMoveToPole);
        // drive.turn(Math.toRadians(-93));
        drive.followTrajectory(moveToStack);
        drive.followTrajectory(moveForward);
        drive.followTrajectory(moveBackward);
        drive.followTrajectory(parking);

        }
    }
