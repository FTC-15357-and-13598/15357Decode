package org.firstinspires.ftc.teamcode.robomossystem;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utility.Constants;

/**
 * This is a test class of a variety of functions, not to be used.
 */
// TODO Turn off motor when not in use
public class intakeShooter {
    // Elevator Constructor
    public intakeShooter(LinearOpMode opmode) {
        myOpMode = opmode;
    }

    // Declare motor with encoder and servo
    private static DcMotor intakeMotor = null;
    private static Servo myServo = null;

    // Define a constructor that allows the OpMode to pass a reference
    private LinearOpMode myOpMode;

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <
     * All of the hardware devices are accessed via the hardware map, and initialized.
     **/
    public void init() {
        // Define and Initialize Motors and servos (note: need to use reference to actual OpMode).
        intakeMotor = myOpMode.hardwareMap.get(DcMotor.class, Constants.IntakeShooter.MOTOR);
        myServo = myOpMode.hardwareMap.get(Servo.class, Constants.IntakeShooter.Servo);
        myServo.setPosition(Constants.IntakeShooter.recievePosition);

        // Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
        // Set to FORWARD if using AndyMark motors
        intakeMotor.setDirection(Constants.IntakeShooter.Direction);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
        // Set the drive motor modes to run with and 0 encoder

    /** This void will be called by both Teleop and Auton to execute periodic items required when
     * other items are not being called by the teleop or auton. Variables declared between this
     * comment and the void are updated by the void for use by the teleop, auton or telemetry
     * class which sends items telemetry or the dashboard
    **/

    public int position, target;
    public double power;
    public boolean AtTarget;
    public String bucketPosition = null;

    public void periodic(){
     //   position =myMotor.getCurrentPosition(); // For adding to dashboard
     //   target= myMotor.getTargetPosition();    // For adding to dashboard
     //   power= myMotor.getPower();              // For adding to dashboard
     //   AtTarget = (Math.abs(position-target)<Constants.IntakeShooter.tolerance);  // For adding to dashboard
        // If motor is within tolerance set motor power to 0 enabling the break
        /*TODO: check motor to insure it is not overheating. If statement below was commented
        *  out to insure it is not causing the elevator to not go down correctly. */
     //   if (!myMotor.isBusy() && (bucketPosition == "down")){
     //       myMotor.setPower(0.0);
     //   }

    }

    public void servoRecieve (){
        myServo.setPosition(Constants.IntakeShooter.recievePosition);
        myOpMode.telemetry.addData("Servo Position",Constants.IntakeShooter.recievePosition);
    }

    public int step=0;
    public void scoreBucket() {
        step=1;
    }

    public void toDown() {
    }
}
