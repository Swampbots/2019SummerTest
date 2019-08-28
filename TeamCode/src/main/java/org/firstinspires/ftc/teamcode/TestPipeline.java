package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.corningrobotics.enderbots.endercv.CameraViewDisplay;

@Disabled
@TeleOp(name = "Pipeline Test", group = "Testing")
public class TestPipeline extends OpMode {

    PipelineSummer vision = new PipelineSummer();

    public void init() {
        vision.init(hardwareMap.appContext, CameraViewDisplay.getInstance(), 0);
        vision.enable();
    }

    public void loop() {

    }

    public void stop() {
        vision.disable();
    }
}
