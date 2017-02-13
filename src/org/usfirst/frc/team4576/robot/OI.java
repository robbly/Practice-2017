package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.Climb;
import org.usfirst.frc.team4576.robot.commands.Gear;
import org.usfirst.frc.team4576.robot.commands.Shift;
import org.usfirst.frc.team4576.robot.commands.Shoot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
// Button Values:
//
// 1: A
// 2: B
// 3: X
// 4: Y
// 5: Left Bumper
// 6: Right Bumper
// 7: Back
// 8: Start
// 9: Left Joystick pressed down
// 10: Right Joystick pressed down
//
//
// Axis values:
//
// 1 - LeftX
// 2 - LeftY
// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
// 4 - RightX
// 5 - RightY
// 6 - DPad Left/Right
public class OI {
	Button dsA = new JoystickButton(Robot.driveStick, 1);
	Button dsB = new JoystickButton(Robot.driveStick, 2);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsY = new JoystickButton(Robot.driveStick, 4);
	Button dsLB = new JoystickButton(Robot.driveStick, 5);
	Button dsRB = new JoystickButton(Robot.driveStick, 6);
	
	
	public OI() {
		dsRB.whileHeld(new Shoot(true));
		dsRB.whenReleased(new Shoot(false));
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsY.whenPressed(new Gear());
		dsLB.whileHeld(new Climb(true));
		dsLB.whenReleased(new Climb(false));


	}
}