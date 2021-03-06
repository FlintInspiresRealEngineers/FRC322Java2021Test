/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.DoNothing;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.subsystems.Chassis;
//import frc.robot.utilities.F310Controller;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
// The robot's subsystems and commands are defined here...
	Command m_autoCommand;

	private final Chassis m_chassis = new Chassis();

	/*private final F310Controller m_driveStick = new F310Controller(Constants.DRIVE_STICK);
	private final F310Controller m_manipulatorStick = new F310Controller(Constants.MANIPULATOR_STICK);*/

	private final Joystick leftDriveJoyStick = new Joystick(2);
	private final Joystick rightDriveJoyStick = new Joystick(3);


	/*private final  JoystickButton m_brakeButton = new JoystickButton(m_driveStick, F310Controller.Button.kA.getValue());*/
	private final  JoystickButton leftJoyStickBrakeButton = new JoystickButton(leftDriveJoyStick, Joystick.ButtonType.kTop.value);
	 
	 

	/**
	 * The container for the robot.  Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Assign default commands
		/*m_chassis.setDefaultCommand(new DriveWithJoystick(
						    ()->m_driveStick.getTriggerAxis(Hand.kRight) - m_driveStick.getTriggerAxis(Hand.kLeft),
						    ()->(m_driveStick.getX(Hand.kLeft)), m_chassis, m_brakeButton));*/

		m_chassis.setDefaultCommand(new DriveWithJoystick(()->leftDriveJoyStick.getY(),
		()-> rightDriveJoyStick.getY()
		,m_chassis, 
		leftJoyStickBrakeButton));

		// Configure the button bindings
		configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		return new DoNothing();
	}
}
