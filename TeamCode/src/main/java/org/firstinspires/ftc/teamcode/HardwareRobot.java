// HardwareRobot Class is for all motors, servos, cameras, etc that IS NOT part of DriveTrain
// DriveTrain motors are located in MecanumDrive

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


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

    public MecanumDrive mecanumDrive;


    // Public opMode Members
    public DcMotorEx turnTable;
    public Servo frontServo;
    public Servo backServo;
    public CRServo intakeServo;

    // Local opMode Members
    public HardwareMap hwMap;

    // Constructor
    public HardwareRobot() {

    }

    // Initialize Standard Hardware Interfaces
    public void init(HardwareMap ahwMap) {

        // Save Reference to HardwareMap
        hwMap = ahwMap;


    }
}