package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.corningrobotics.enderbots.endercv.CameraViewDisplay;

@TeleOp(name = "Pipeline Test", group = "Testing")
public class TestPipeline extends OpMode {

    PipelineSummer vision = new PipelineSummer();

    public void init() {
        vision.init(hardwareMap.appContext, CameraViewDisplay.getInstance(), 0);
    }

    public void loop() {

    }
}
