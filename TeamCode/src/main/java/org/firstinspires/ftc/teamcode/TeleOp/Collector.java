package org.firstinspires.ftc.teamcode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.HardwareRobot;

public class Collector {

    HardwareRobot robot;

    public Collector(HardwareRobot r) {

        robot = r;
    }

    public void Update(Gamepad gamepad1, Gamepad gamepad2) {

        // Y - Collector/Depositor Moves
        if (gamepad1.y) {
            robot.collectorLeft.setPower(0.2);
            robot.collectorRight.setPower(-0.2);

        } else {
            robot.collectorLeft.setPower(0);
            robot.collectorRight.setPower(0);
        }


    }

}