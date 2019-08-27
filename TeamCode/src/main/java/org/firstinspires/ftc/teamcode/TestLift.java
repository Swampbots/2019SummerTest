package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Lift Test")
public class TestLift extends OpMode {

    public DcMotor lift;

    public void init() {
        lift = hardwareMap.dcMotor.get("lift");
    }

    public void loop() {
        lift.setPower(gamepad1.left_stick_y);
    }
}
