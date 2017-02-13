package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public Pneumatics() {
		s0 = new Solenoid(0);/* Shifting */
		s1 = new Solenoid(1);/* Advancing */
		s2 = new Solenoid(2);/* Gear */

	}

	private Compressor c;
	private Solenoid s0,s1,s2;
	@Override
	protected void initDefaultCommand() {
		c = new Compressor();
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}
//Shifting
	public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shiftUp() {
		s0.set(true);

	}

	public void shiftDown() {
		s0.set(false);
	}
//Ball Advancing
	public void setAdvance(boolean closed) {
		s1.set(closed);
	}
	public void advance() {
		s1.set(!s1.get());

	}
//Gear Grabbing
	public void setGear(boolean closed) {
		s2.set(closed);
	}
	
	public void gear() {
		s2.set(!s2.get());

	}
	
//Compressor Toggle
	public void toggleComp() {
		if (c.enabled())
			c.stop();
		else
			c.start();
	}

	public void stopComp() {
		c.stop();
	}

}
