package org.usfirst.frc.team4576.robot.subsystems;


import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
		StringBuilder _sb = new StringBuilder();
		int _loops = 0;
		CANTalon tsrxS = new CANTalon(4);		
		
		double motorOutput = tsrxS.getOutputVoltage() / tsrxS.getBusVoltage();
		double targetSpeed = (double) (2000);
		
		public Shooter() {	
		tsrxS.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		tsrxS.reverseSensor(false);
		tsrxS.changeControlMode(TalonControlMode.Speed);
		tsrxS.configNominalOutputVoltage(+0.0f, -0.0f);
		tsrxS.configPeakOutputVoltage(+12.0f, 0.0f);
		/* set closed loop gains in slot0 */
		

		tsrxS.setProfile(0);
		tsrxS.setF(.03);
		tsrxS.setP(0);
		tsrxS.setI(0);
		tsrxS.setD(0);
		}
	public void shoot() {
		
		tsrxS.set(targetSpeed);
		
	}
	/*public void Shoot() {
	tsrxS.set(targetSpeed); /* 1500 RPM in either direction */


	public void stop() {
	tsrxS.set(0);
	}
	public void printRPM() {

		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(tsrxS.getSpeed());

			/* Speed mode */
			

			/* append more signals to print when in speed mode. */
			_sb.append("\terr:");
			_sb.append(tsrxS.getClosedLoopError());
			_sb.append("\ttrg:");
			_sb.append(targetSpeed);
	
		if (++_loops >= 10) {
			_loops = 0;
			System.out.println(_sb.toString());
		}
		_sb.setLength(0);
	
	}
	protected void initDefaultCommand() {
	/* get gamepad axis */
		
	}

}
