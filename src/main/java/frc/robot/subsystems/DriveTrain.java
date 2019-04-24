/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.commands.drivetrain.RobotDrive;

public class DriveTrain extends Subsystem {

  private WPI_TalonSRX fL, rL, fR, rR;
  private SpeedControllerGroup leftTank, rightTank;
  public DifferentialDrive driveBase;

  public DriveTrain() {
    fL = new WPI_TalonSRX(Constants.LEFT_FRONT_MOTOR);
    rL = new WPI_TalonSRX(Constants.LEFT_REAR_MOTOR);
    fR = new WPI_TalonSRX(Constants.RIGHT_FRONT_MOTOR);
    rR = new WPI_TalonSRX(Constants.RIGHT_REAR_MOTOR);

    leftTank = new SpeedControllerGroup(fL, rL);
    rightTank = new SpeedControllerGroup(fR, rR);

    driveBase = new DifferentialDrive(leftTank, rightTank);
    
    driveBase.setSafetyEnabled(true);
    driveBase.setExpiration(.1);
  }

  public void robotDrive(double speed, double rotation, double modifier) {
    driveBase.arcadeDrive(-(speed)*modifier, (rotation)*modifier);
  }

  public void stop() {
    driveBase.arcadeDrive(0, 0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RobotDrive());
  }
}
