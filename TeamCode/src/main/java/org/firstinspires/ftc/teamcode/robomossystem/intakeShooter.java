package org.firstinspires.ftc.teamcode.robomossystem;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.utility.Constants;

// Create class for intake and shooter subsystem
public class intakeShooter {
    // Private instance fo singleton pattern
    private static intakeShooter instance;

    //Private consturctor contaning installation code
    public intakeShooter(LinearOpMode opmode) {
        //Define and configure dardware
        intakeMotor = myOpMode.hardwareMap.get(DcMotor.class, Constants.IntakeShooter.intakeMotor);
        intakeMotor.setDirection(Constants.IntakeShooter.intakeDirection);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterMotor = myOpMode.hardwareMap.get(DcMotorEx.class,Constants.IntakeShooter.shooterMotor);
        shooterMotor.setDirection(Constants.IntakeShooter.shooterDirection);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterServo = myOpMode.hardwareMap.get(Servo.class, Constants.IntakeShooter.intakeServo);
        shooterServo.setDirection(Constants.IntakeShooter.intkServDirec);

        myOpMode = opmode;
    }

    //Public get instance for opmode to access class
   // public static intakeShooter getInstance(){
   //     if (instance ==null)
   //         instance = new intakeShooter(getInstance().myOpMode);
   //     return instance;
   // }



    // Declare motor with encoder and servo
    private static DcMotor intakeMotor = null;
    private static DcMotorEx shooterMotor = null;
    private static Servo shooterServo = null;

    // Define a constructor that allows the OpMode to pass a reference
    private LinearOpMode myOpMode;



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
     //   }

    }

    public void runIntake (){
       intakeMotor.setPower(Constants.IntakeShooter.intakePower);
        myOpMode.telemetry.addData("Intake Power",Constants.IntakeShooter.intakePower);
    }

    public void stopIntake (){
        intakeMotor.setPower(0.0);
        myOpMode.telemetry.addData("Intake Power",0.0);
    }

    public void reverseIntake (){
        intakeMotor.setPower(Constants.IntakeShooter.intakeRevPower);
        myOpMode.telemetry.addData("Intake Power",Constants.IntakeShooter.intakeRevPower);
    }

    public void runShooter(){
        shooterMotor.setPower(Constants.IntakeShooter.shootPower);
        myOpMode.telemetry.addData("Shooter Power",Constants.IntakeShooter.shootPower);
    }

    public void revShooter(){
        shooterMotor.setPower(Constants.IntakeShooter.shooterBackUpPower);
        myOpMode.telemetry.addData("Shooter Power",Constants.IntakeShooter.shooterBackUpPower);
    }

    public void stopShooter(){
        shooterMotor.setPower(0.0);
        myOpMode.telemetry.addData("Shooter Power",0.0);
    }

    public boolean shootAtSpd = (shooterMotor.getPower() >1600.0);

    public void servoForward(){
        shooterServo.setPosition(Constants.IntakeShooter.servoShoot);
    }

    public void stopServo(){
        shooterServo.setPosition(Constants.IntakeShooter.servoStop);
    }

    public void servoReverse(){
        shooterServo.setPosition(Constants.IntakeShooter.servoStop);
    }

    public void shoot(){
        runShooter();
        if (shootAtSpd) {
            servoForward();
        }
        else {
            stopServo();
        }
    }
}
