/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Arms;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FrontClimber;
import frc.robot.subsystems.RearClimber;
import frc.robot.subsystems.RearHatch;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.Vision;

import util.Log;
import util.MessageType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class QUASAR extends TimedRobot {

  public static OI oi;
  public static DriveTrain driveTrain;
  public static Elevator elevator;
  public static Sensors sensors;
  public static Arms arms;
  public static RearHatch rearHatch;
  public static FrontClimber frontClimber;
  public static RearClimber rearClimber;
  public static Vision vision;

  private Compressor compressor;

  @Override
  public void robotInit() {

    Log.WriteLine(MessageType.INFO, "Initializing robot...");

    try {

      driveTrain = new DriveTrain();
      elevator = new Elevator();
      sensors = new Sensors();
      arms = new Arms();
      rearHatch = new RearHatch();
      frontClimber = new FrontClimber();
      rearClimber = new RearClimber();
      vision = new Vision();
      
      oi = new OI();

      compressor = new Compressor(Constants.COMPRESSOR_PORT);

    } catch (Exception ex) {
      Log.WriteLine(MessageType.ERROR, ex.toString());

    }

    compressor.start();
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
