package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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

    }
    public void loop(){


        telemetry.addData("rlDrive power", rlDrive.getPower());
        telemetry.addData("rrDrive power", rrDrive.getPower());
        telemetry.addData("flDrive power", flDrive.getPower());
        telemetry.addData("frDrive power", frDrive.getPower());
        telemetry.update();
    }

}
