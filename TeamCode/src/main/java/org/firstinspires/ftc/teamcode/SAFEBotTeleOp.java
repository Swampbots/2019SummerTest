package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SAFE Bot", group = "Demo")
public class SAFEBotTeleOp extends OpMode {

    public DcMotor lift;

    public DcMotor intake1;
    public DcMotor intake2;

    public Servo gripper;


    public void init() {

        lift        = hardwareMap.dcMotor.get("lift");

        intake1     = hardwareMap.dcMotor.get("intake1");
        intake2     = hardwareMap.dcMotor.get("intake2");

        gripper     = hardwareMap.servo.get("gripper");

        lift.setDirection(DcMotorSimple.Direction.REVERSE);

        intake2.setDirection(DcMotorSimple.Direction.REVERSE);


        telemetry.addLine("Ready");
        telemetry.update();
    }

    public void loop() {

        lift.setPower(gamepad1.right_stick_y);

        if(gamepad1.a) {
            setIntakePower(1.0);
        } else if(gamepad1.b) {
            setIntakePower(-1.0);
        } else {
            setIntakePower(0.0);
        }

        if(gamepad1.y) gripper.setPosition(1.0);
        else gripper.setPosition(0.0);

        telemetry.addLine("Running in safe mode");
        telemetry.addData("Lift power", lift.getPower());
        telemetry.update();
    }

    public void setIntakePower(double power) {
        intake1.setPower(power);
        intake2.setPower(power);
    }
}
