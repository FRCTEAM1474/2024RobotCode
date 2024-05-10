// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

//import edu.wpi.first.apriltag.AprilTagFieldLayout;
//import edu.wpi.first.apriltag.AprilTagFields;
//import edu.wpi.first.math.Matrix;
//import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
//import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
//import edu.wpi.first.math.numbers.N1;
//import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;
import java.util.List;
import swervelib.parser.PIDFConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

  public static final double ROBOT_MASS = (97) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(Units.inchesToMeters(0), Units.inchesToMeters(0), Units.inchesToMeters(8
  )), ROBOT_MASS*0.75);
  public static final Matter ARM_HEAD   = new Matter(new Translation3d(Units.inchesToMeters(0), Units.inchesToMeters(0), Units.inchesToMeters(24
  )), ROBOT_MASS*0.25);
  public static final List<Matter> ROBOT_MATTER = List.of(CHASSIS, ARM_HEAD);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double ROBORADIUS = 0.51; //distance from center to farthest point on a module

  public static final class Auton
  {

    //public static final PIDFConfig xAutoPID     = new PIDFConfig(0.7, 0, 0);
    //public static final PIDFConfig yAutoPID     = new PIDFConfig(0.7, 0, 0);
    //public static final PIDFConfig angleAutoPID = new PIDFConfig(0.4, 0, 0.01);

    public static final double MAX_SPEED        = 4.6;
    public static final double MAX_ACCELERATION = 2;
  }

  public static final class Drivebase
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static final class Climber {
    public static final double MAX_HEIGHT_LEFT_ENCODER_VALUE = -600;
    public static final double MAX_HEIGHT_RIGHT_ENCODER_VALUE = 600; //TODO: replace these dummy values with real ones
  }

  public static final class Arm {
    public static final int kLeftMotorPort = 26;
    public static final int kRightMotorPort = 25;
    public static final double kMaxVelocityRadPerSecond = 1;
    public static final double kGVolts = 0.18;
    public static final double kVVoltSecondPerRad = 11.13;
    public static final double kAVoltSecondSquaredPerRad = 0.01;
    public static final double kSVolts = 0.8; //try 0.8 if it doesn't work
    public static final double kP = 45; //tiny oscillation at 50
    public static final double kMaxAccelerationRadPerSecSquared = 1;
    //public static final double kArmOffsetRads = Math.PI/2;
    public static final double kEncoderDistancePerRotation = 2*Math.PI;
    public static final double kStartingPos = Math.toRadians(75);//0.214*Math.PI*2;//0.610
    public static final double kAmpShootPos = Math.toRadians(90); //0.269*Math.PI*2;//0.665
    public static final double kClimbingandFrontSpeakerShootPos = Math.toRadians(15); //was 15, changed to 18 to compensate for bad offset0.396*Math.PI*2; //0.396
    public static final double kIntakePos = Math.toRadians(5);
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND = 0.25;
    public static final double LEFT_Y_DEADBAND = 0.25;

    public static final double ROTATION_DEADBAND = 0.25;

    public static final double TURN_CONSTANT = 15;

    public static final double kSensitivity = 3.0;
  }

    public static class Vision {
        public static final String FRONT_CAMERA_NAME = "limelight";

        // TODO: measure these offsets
        public static final Pose3d FRONT_CAMERA_POSE = new Pose3d(-0.2744, 0, 0.236, new Rotation3d(0,Math.toRadians(32),Math.toRadians(180))); //old pitch 0.559 rad

        // TODO: find these values
        public static final double MAX_VISION_DELAY_SECS = 0.08;
        public static final double MAX_ACCEPTED_ROT_SPEED_RAD_PER_SEC = 1.0;
        public static final double MAX_ACCEPTED_LINEAR_SPEED_MPS = 4.0;
        public static final double MIN_ACCEPTED_NUM_TAGS = 1;
        public static final double MAX_ACCEPTED_AVG_TAG_DIST_METERS = 8.0;

        public static final int SIM_RES_WIDTH = 1280;
        public static final int SIM_RES_HEIGHT = 960;
        public static final Rotation2d SIM_DIAGONAL_FOV = Rotation2d.fromDegrees(100);
        public static final double SIM_FPS = 14.5;
        public static final double SIM_AVG_LATENCY_MS = 67.0;
    }

    public static class MotorLimit {
      public static class Neo {
        public static final int stall = 60;
        public static final int free  = 40;
        public static final int stallRPM = 0; // 0 for linear limit
      }
      public static class Neo550 {
        public static final int stall = 40;
        public static final int free  = 20;
        public static final int stallRPM = 0; // 0 for linear limit
      }
    }

    public static final HolonomicPathFollowerConfig pathFollowerConfig = new HolonomicPathFollowerConfig(
      new PIDConstants(0.0020645, 0, 0), // Translation constants 
      new PIDConstants(0.03, 0, 0), // Rotation constants 
      Auton.MAX_SPEED, 
      ROBORADIUS, // Drive base radius (distance from center to furthest module) 
      new ReplanningConfig(true, true)
    );
}
