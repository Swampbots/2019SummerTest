package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name= "TileRunner Test")
public class TestTileRunner extends OpMode {

    public DcMotor rlDrive;
    public DcMotor rrDrive;
    public DcMotor flDrive;
    public DcMotor frDrive;

    public void init(){
        rlDrive = hardwareMap.dcMotor.get("rl_drive");
        rrDrive = hardwareMap.dcMotor.get("rr_drive");
        flDrive = hardwareMap.dcMotor.get("fl_drive");
        frDrive = hardwareMap.dcMotor.get("fr_drive");

        frDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rrDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void loop(){


        setLeftPower(0.2);
        setRightPower(0.2);

        telemetry.addData("rlDrive power", rlDrive.getPower());
        telemetry.addData("rrDrive power", rrDrive.getPower());
        telemetry.addData("flDrive power", flDrive.getPower());
        telemetry.addData("frDrive power", frDrive.getPower());
        telemetry.update();
    }

    public void setLeftPower(double power){
        rlDrive.setPower(power);
        flDrive.setPower(power);

    }

    public void setRightPower(double power){
        rrDrive.setPower(power);
        frDrive.setPower(power);


    }

}
