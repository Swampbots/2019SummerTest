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
    public DcMotor lift;

    public final boolean BRAKE_ON_ZERO = true;

    public void init() {
        frontLeft   = hardwareMap.dcMotor.get("fl_drive");
        frontRight  = hardwareMap.dcMotor.get("fr_drive");
        rearLeft    = hardwareMap.dcMotor.get("rl_drive");
        rearRight   = hardwareMap.dcMotor.get("rr_drive");

        lift        = hardwareMap.dcMotor.get("lift");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        if(BRAKE_ON_ZERO) {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

            lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        telemetry.addLine("Ready");
        telemetry.update();
    }

    public void loop() {
        frontLeft.setPower(gamepad1.left_stick_y * 0.6);
        frontRight.setPower(gamepad1.right_stick_y * 0.6);

        rearLeft.setPower(gamepad1.left_stick_y * 0.6);
        rearRight.setPower(gamepad1.right_stick_y * 0.6); 

        lift.setPower(gamepad1.left_trigger - gamepad1.right_trigger);


        telemetry.addData("Front Left power", frontLeft.getPower());
        telemetry.addData("Front Right power", frontRight.getPower());
        telemetry.addLine();
        telemetry.addData("Rear Left power", rearLeft.getPower());
        telemetry.addData("Rear Right power", rearRight.getPower());
//        lift.setPower(gamepad1.left_trigger - gamepad1.right_trigger);
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
}
