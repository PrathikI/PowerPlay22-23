package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.sun.tools.javac.util.List;

import org.firstinspires.ftc.teamcode.Drive.MyMecanumDrive;
import org.firstinspires.ftc.teamcode.TeleOp.DriveTrain;
import org.firstinspires.ftc.teamcode.TeleOp.Collector;
import org.firstinspires.ftc.teamcode.Util.LynxModuleUtil;

import java.util.Arrays;


/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */

public class HardwareRobot {

    // Public opMode Members
    public MyMecanumDrive mecanumDrive;
    public DcMotorEx frontRight;
    public DcMotorEx frontLeft;
    public DcMotorEx backRight;
    public DcMotorEx backLeft;
    public DcMotor collectorLeft;
    public DcMotor collectorRight;
    public List<DcMotorEx> motors;
    public BNO055IMU imu;
    public VoltageSensor batteryVoltageSensor;

    // Referencing DriveTrain class
    DriveTrain DriveTrain;
    Collector Collector;


    // Local opMode Members
    public HardwareMap hwMap;

    // Constructor
    public HardwareRobot() {

    }



    // Initialize Standard Hardware Interfaces
    public void init(HardwareMap ahwMap) {

        // Save Reference to HardwareMap
        hwMap = ahwMap;


        // Define and Initialize Motors
        frontRight = hwMap.get(DcMotorEx.class, "frontRight");
        frontLeft = hwMap.get(DcMotorEx.class, "frontLeft");
        backRight = hwMap.get(DcMotorEx.class, "backRight");
        backLeft = hwMap.get(DcMotorEx.class, "backLeft");
        collectorLeft = hwMap.get(DcMotor.class, "collectorLeft");
        collectorRight = hwMap.get(DcMotor.class, "collectorRight");

        // Reverse Directions
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        // Run Using Encoders
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        collectorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        collectorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // All the Autonomous/HardwareMap stuff
        LynxModuleUtil.ensureMinimumFirmwareVersion(hwMap);
        batteryVoltageSensor = hwMap.voltageSensor.iterator().next();
        for (LynxModule module : hwMap.getAll(LynxModule.class)) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }

        imu = hwMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);
        motors = (List<DcMotorEx>) Arrays.asList(frontLeft, backLeft, backRight, frontRight);

        // Make sure always the last line (all stuff needed for drivetrain)
        mecanumDrive = new MyMecanumDrive(this);

    }
}