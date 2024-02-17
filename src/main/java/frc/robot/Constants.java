// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;
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

  public static final double ROBOT_MASS = (25) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(Units.inchesToMeters(28), Units.inchesToMeters(28), Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double ROBORADIUS = 0.5; //distance from center to farthest point on a module

  public static final class Auton
  {

    public static final PIDFConfig xAutoPID     = new PIDFConfig(0.7, 0, 0);
    public static final PIDFConfig yAutoPID     = new PIDFConfig(0.7, 0, 0);
    public static final PIDFConfig angleAutoPID = new PIDFConfig(0.4, 0, 0.01);

    public static final double MAX_SPEED        = 4.6;
    public static final double MAX_ACCELERATION = 2;
  }

  public static final class Drivebase
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND = 0.01;
    public static final double LEFT_Y_DEADBAND = 0.01;
  }

  /*public static class Vision {
        public static final String kCameraName = "photonvision";
        // Cam mounted facing forward, half a meter forward of center, half a meter up from center.
        public static final Transform3d kRobotToCam =
                new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0, 0, 0));

        // The layout of the AprilTags on the field
        public static final AprilTagFieldLayout kTagLayout =
                AprilTagFields.kDefaultField.loadAprilTagLayoutField();

        // The standard deviations of our vision estimated poses, which affect correction rate
        // (Fake values. Experiment and determine estimation noise on an actual robot.)
        public static final Matrix<N3, N1> kSingleTagStdDevs = VecBuilder.fill(4, 4, 8);
        public static final Matrix<N3, N1> kMultiTagStdDevs = VecBuilder.fill(0.5, 0.5, 1);
    }*/

    public static class Vision {
        public static final String FRONT_CAMERA_NAME = "limelight-front";

        // TODO: measure these offsets
        public static final Pose3d FRONT_CAMERA_POSE = new Pose3d(0.2774, 0, 0.2271, new Rotation3d(0,0.559,0));

        // TODO: find these values
        public static final double MAX_VISION_DELAY_SECS = 0.08;
        public static final double MAX_ACCEPTED_ROT_SPEED_RAD_PER_SEC = 1.0;
        public static final double MAX_ACCEPTED_LINEAR_SPEED_MPS = 4.0;
        public static final double MIN_ACCEPTED_NUM_TAGS = 1;
        public static final double MAX_ACCEPTED_AVG_TAG_DIST_METERS = 8.0;
        public static final double MAX_ACCEPTED_ELEVATOR_SPEED_MPS = 0.05;

        public static final int SIM_RES_WIDTH = 1280;
        public static final int SIM_RES_HEIGHT = 960;
        public static final Rotation2d SIM_DIAGONAL_FOV = Rotation2d.fromDegrees(100);
        public static final double SIM_FPS = 14.5;
        public static final double SIM_AVG_LATENCY_MS = 67.0;
    }

    public static final HolonomicPathFollowerConfig pathFollowerConfig = new HolonomicPathFollowerConfig(
      new PIDConstants(0.7, 0, 0), // Translation constants 
      new PIDConstants(0.4, 0, 0.01), // Rotation constants 
      Auton.MAX_SPEED, 
      ROBORADIUS, // Drive base radius (distance from center to furthest module) 
      new ReplanningConfig(true, true)
    );
}
