
package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Climber;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4576.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Climber climber = new Climber();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Shooter shooter = new Shooter();
	public static OI oi;
	

	public static Joystick driveStick = new Joystick(0);


	Command teleopCommand;
	Command autonomousCommand;


	public void robotInit() {
		System.out.println("RNR 2017 Robot Code Initializing...");
		oi = new OI();


		teleopCommand = new DriveWithJoysticks();

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopCommand.start();

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Robot.shooter.printRPM();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}

