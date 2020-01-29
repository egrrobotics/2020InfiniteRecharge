/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeDrive;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Talons.
  TalonSRX lift, spinner;

  // Setup.
  public Intake() {
    lift = new TalonSRX(RobotMap.intakeLift);
    spinner = new TalonSRX(RobotMap.intakeSpinner);
  }

  // Limiter.
  private double limiter(double value, double lowerLimit, double upperLimit) {
    if (Math.abs(value) < lowerLimit) { value = 0; }
    if (Math.abs(value) > upperLimit) {
      if (value > 0) { value = upperLimit; }
      if (value < 0) { value = -upperLimit; }
    }
    return value;
  }

  // Lift power.
  public void setLiftPower(double liftPower) {
    lift.set(ControlMode.PercentOutput, limiter(liftPower, 0.1, 0.5));
  }

  // Lift encoder position.
  public double getLiftPos() {
    return lift.getSelectedSensorPosition();
  }

  // Spinner power.
  public void setSpinnerPower(double spinnerPower) {
    spinner.set(ControlMode.PercentOutput, limiter(spinnerPower, 0.1, 0.8)/2);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new IntakeDrive());
  }
}
