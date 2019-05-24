/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//#region Imports
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
//#endregion

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {

  public WPI_TalonSRX elevatorMotor;

  //#region Subsystem Constructor
  public Elevator() {
    elevatorMotor = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR);

    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.PID_ID,
      Constants.TIMEOUT_MS);

    elevatorMotor.setSensorPhase(Constants.SENSOR_PHASE);
    elevatorMotor.setInverted(Constants.SENSOR_PHASE);

    /*elevatorMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
    elevatorMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);

    elevatorMotor.configPeakOutputForward(1, Constants.TIMEOUT_MS);
    elevatorMotor.configPeakOutputReverse(-1, Constants.TIMEOUT_MS);

    elevatorMotor.configAllowableClosedloopError(0, Constants.PID_ID, Constants.TIMEOUT_MS);

    elevatorMotor.config_kF(Constants.PID_ID, Constants.PID_Gains._F, Constants.TIMEOUT_MS);
    elevatorMotor.config_kP(Constants.PID_ID, Constants.PID_Gains._P, Constants.TIMEOUT_MS);
    elevatorMotor.config_kI(Constants.PID_ID, Constants.PID_Gains._I, Constants.TIMEOUT_MS);
    elevatorMotor.config_kD(Constants.PID_ID, Constants.PID_Gains._D, Constants.TIMEOUT_MS);

    int absolutePosition = elevatorMotor.getSensorCollection().getPulseWidthPosition();

    absolutePosition &= 0xFFF; // mask out overflows, keep bottom 12 bits

    if (Constants.SENSOR_PHASE) { absolutePosition *= -1; }
    if (Constants.PID_INVERT) { absolutePosition *= -1; }

    elevatorMotor.setSelectedSensorPosition(absolutePosition, Constants.PID_ID, Constants.TIMEOUT_MS);*/
  }
  //#endregion

  //#region Subsystem Functions
  public int getPosition() {
    return elevatorMotor.getSelectedSensorPosition();
  }

  public void up() {
    elevatorMotor.set(1);
  }

  public void down() {
    elevatorMotor.set(-1);
  }

  public void stop() {
    elevatorMotor.set(0);
  }

  public void zero() {
    stop();
    elevatorMotor.setSelectedSensorPosition(0);
  }

  public void moveToPreset(int preset) {
    elevatorMotor.set(ControlMode.Position, preset);
  }
  //#endregion

  @Override
  public void initDefaultCommand() {
  }
}
