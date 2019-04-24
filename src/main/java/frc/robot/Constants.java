/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import util.controls.PIDGains;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
      // Elevator Presets
      public static int PRESET_BALL_LOW = 8000;
      public static int PRESET_BALL_MED = 17900;
      public static int PRESET_BALL_HIGH = 24200;
  
      public static int PRESET_HATCH_LOW = 5500;
      public static int PRESET_HATCH_MED = 15500;
      public static int PRESET_HATCH_HIGH = 24100;
  
      // Drive Train
      public static int LEFT_FRONT_MOTOR = 3;
      public static int LEFT_REAR_MOTOR = 4;
      public static  int RIGHT_FRONT_MOTOR = 0;
      public static int RIGHT_REAR_MOTOR = 1;

      public static double ROBOT_DRIVE_MODIFIER = 0.66;
      public static double AXIS_THRESHOLD = 0.15;
  
      // Elevator
      public static int ELEVATOR_MOTOR = 2;
  
      // Controls
      public static int DRIVER_CONTROLLER = 0;
      public static int OPERATOR_CONTROLLER = 1;

      public static int LEFT_X = 0;
      public static int LEFT_Y = 1;
      public static int LEFT_TRIGGER = 2;
      public static int RIGHT_TRIGGER = 3;
      public static int RIGHT_X = 4;
      public static int RIGHT_Y = 5;

      public static int A_BUTTON = 1;
      public static int B_BUTTON = 2;
      public static int X_BUTTON = 3;
      public static int Y_BUTTON = 4;
      public static int LEFT_SHOULDER = 5;
      public static int RIGHT_SHOULDER = 6;
      public static int SELECT_BUTTON = 7;
      public static int START_BUTTON = 8;
      public static int LS_PUSH = 9;
      public static int RS_PUSH = 10;

      // Sensors
      public static int ELEVATOR_LIMIT_SWITCH = 0;
      public static int FLOOR_SENSOR_F = 1;
      public static int FLOOR_SENSOR_R = 2;
      public static int HATCH_LIMIT_SWITCH = 3;

      
      // Pneumatics
      public static int COMPRESSOR_PORT = 0;
      public static int CLIMBER_REAR = 0;
      public static int CLIMBER_FRONT = 1;
      public static int ARMS_SOLENOID = 2;
      public static int BACKHATCH_KICKER = 4;
      public static int BACKHATCH_FLOWER = 5;
  
      // Camera
      public static String CAMERA_NAME = "limelight";

    // PID
    public static int PID_ID = 0;
    public static int SLOT_ID = 0;
    public static int TIMEOUT_MS = 30;
    public static boolean SENSOR_PHASE = true;
    public static boolean PID_INVERT = false;
    public static final PIDGains PID_Gains = new PIDGains(0.15, 0.0, 1.0, 0.0, 0, 1.0);
}
