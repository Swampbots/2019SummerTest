package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SAFE Bot", group = "Demo")
public class SAFEBotTeleOp extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor rearLeft;
    public DcMotor rearRight;

    public DcMotor lift;

    public DcMotor intake1;
    public DcMotor intake2;

    public Servo gripper;


    public void init() {
        frontLeft   = hardwareMap.dcMotor.get("fl_drive");
        frontRight  = hardwareMap.dcMotor.get("fr_drive");
        rearLeft    = hardwareMap.dcMotor.get("rl_drive");
        rearRight   = hardwareMap.dcMotor.get("rr_drive");

        lift        = hardwareMap.dcMotor.get("lift");

        intake1     = hardwareMap.dcMotor.get("intake1");
        intake2     = hardwareMap.dcMotor.get("intake2");

        gripper     = hardwareMap.servo.get("gripper");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        lift.setDirection(DcMotorSimple.Direction.REVERSE);

        intake2.setDirection(DcMotorSimple.Direction.REVERSE);


        telemetry.addLine("Ready");
        telemetry.update();
    }

    public void loop() {
        double drive = (gamepad2.left_trigger - gamepad2.right_trigger) * 0.3;
        double turn = gamepad2.left_stick_x * 3 / 4 * 0.3;

        double speedMod = 1.0;

        if(drive > 0.0) {
            setLeftPower((drive + turn) * speedMod);
            setRightPower((drive - turn) * speedMod);
        } else {
            setLeftPower((drive - turn) * speedMod);
            setRightPower((drive + turn) * speedMod);
        }


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

    public void setLeftPower(double power){
        rearLeft.setPower(power);
        frontLeft.setPower(power);

    }

    public void setRightPower(double power){
        rearRight.setPower(power);
        frontRight.setPower(power);
    }

    public void setIntakePower(double power) {
        intake1.setPower(power);
        intake2.setPower(power);
    }
}
