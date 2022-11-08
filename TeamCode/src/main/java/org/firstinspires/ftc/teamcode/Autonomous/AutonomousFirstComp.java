package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Drive.MyMecanumDrive;
import org.firstinspires.ftc.teamcode.HardwareRobot;
import org.firstinspires.ftc.teamcode.TeleOp.Collector;
import org.firstinspires.ftc.teamcode.TeleOp.DriveTrain;

@Autonomous
public class AutonomousFirstComp extends LinearOpMode{


    @Override

    public void runOpMode() throws InterruptedException {

        HardwareRobot robot = new HardwareRobot();
        ElapsedTime timer = new ElapsedTime();

        robot.init(hardwareMap);

        DriveTrain driveTrain = new DriveTrain(robot, timer);
        Collector collector = new Collector(robot);

        waitForStart();

        Trajectory myTrajectory = robot.mecanumDrive.trajectoryBuilder(new Pose2d())
                .forward(5)
                .build();

        robot.mecanumDrive.followTrajectory(myTrajectory);

    }
}
