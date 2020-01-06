/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Core.
package frc.robot;

// Controller.
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {

  /////////////////////////////// DOCUMENTATION ///////////////////////////////

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  /////////////////////////////////////////////////////////////////////////////

  // Driver controller and buttons.
  public Joystick driverJoystick = new Joystick(0);
  public Button driverButtonA = new JoystickButton(driverJoystick, 1);
  public Button driverButtonB = new JoystickButton(driverJoystick, 2);
  public Button driverButtonX = new JoystickButton(driverJoystick, 3);
  public Button driverButtonY = new JoystickButton(driverJoystick, 4);
  public Button driverButtonLeftBumper = new JoystickButton(driverJoystick, 5);
  public Button driverButtonRightBumper = new JoystickButton(driverJoystick, 6);
  public Button driverButtonBack = new JoystickButton(driverJoystick, 7);
  public Button driverButtonStart = new JoystickButton(driverJoystick, 8);
  public Button driverButtonLeftAxisPress = new JoystickButton(driverJoystick, 9);
  public Button driverButtonRightAxisPress = new JoystickButton(driverJoystick, 10);

  // Operator controller and buttons.
  public Joystick operatorJoystick = new Joystick(1);
  public Button operatorButtonA = new JoystickButton(operatorJoystick, 1);
  public Button operatorButtonB = new JoystickButton(operatorJoystick, 2);
  public Button operatorButtonX = new JoystickButton(operatorJoystick, 3);
  public Button operatorButtonY = new JoystickButton(operatorJoystick, 4);
  public Button operatorButtonLeftBumper = new JoystickButton(operatorJoystick, 5);
  public Button operatorButtonRightBumper = new JoystickButton(operatorJoystick, 6);
  public Button operatorButtonBack = new JoystickButton(operatorJoystick, 7);
  public Button operatorButtonStart = new JoystickButton(operatorJoystick, 8);
  public Button operatorButtonLeftAxisPress = new JoystickButton(operatorJoystick, 9);
  public Button operatorButtonRightAxisPress = new JoystickButton(operatorJoystick, 10);

  // Mapping initialization.
  public OI() {

    // Drivetrain-related mappings are located in the ArcadeDrive command.

  }

}
