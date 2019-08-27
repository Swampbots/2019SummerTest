package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Driver Control", group = "TeleOp")
public class SLICBotTeleOp extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor rearLeft;
    public DcMotor rearRight;

    public final boolean BRAKE_ON_ZERO = true;

    public void init() {
        frontLeft   = hardwareMap.dcMotor.get("fl_drive");
        frontRight  = hardwareMap.dcMotor.get("fr_drive");
        rearLeft    = hardwareMap.dcMotor.get("rl_drive");
        rearRight   = hardwareMap.dcMotor.get("rr_drive");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        if(BRAKE_ON_ZERO) {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        telemetry.addLine("Ready");
        telemetry.update();
    }

    public void loop() {
        frontLeft.setPower(gamepad1.left_stick_y * gamepad1.left_stick_y * gamepad1.left_stick_y);
        frontRight.setPower(gamepad1.right_stick_y * gamepad1.right_stick_y * gamepad1.right_stick_y);

        rearLeft.setPower(gamepad1.left_stick_y * gamepad1.left_stick_y * gamepad1.left_stick_y);
        rearRight.setPower(gamepad1.right_stick_y * gamepad1.right_stick_y * gamepad1.right_stick_y);


        telemetry.addData("Front Left power", frontLeft.getPower());
        telemetry.addData("Front Right power", frontRight.getPower());
        telemetry.addLine();
        telemetry.addData("Rear Left power", rearLeft.getPower());
        telemetry.addData("Rear Right power", rearRight.getPower());
        telemetry.update();
    }
}
