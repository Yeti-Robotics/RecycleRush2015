package org.yetirobotics.frc.team3506.robot.subsystems;

import org.yetirobotics.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RobotArm extends Subsystem {

	Talon rightArm;
	Talon leftArm;

	DoubleSolenoid clawRight;
	DoubleSolenoid clawLeft;

	Relay clawBelt;

	public RobotArm() {
		rightArm = new Talon(RobotMap.RIGHT_ARM_PORT);
		leftArm = new Talon(RobotMap.LEFT_ARM_PORT);

		clawRight = new DoubleSolenoid(0, 1);
		clawLeft = new DoubleSolenoid(2, 3);
		
		clawBelt = new Relay(0);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public void armDown(double speed) {
		rightArm.set(speed);
		leftArm.set(speed);
	}

	public void armUp(double speed) {
		rightArm.set(-speed);
		leftArm.set(-speed);
	}
	
	public void stopArm () {
		rightArm.disable();
		leftArm.disable();
	}

	public void clawClose() {
		clawRight.set(Value.kForward);
		clawLeft.set(Value.kForward);
	}

	public void clawOpen() {
		clawRight.set(Value.kReverse);
		clawLeft.set(Value.kReverse);
	}

	public void clawBeltPush() {
		clawBelt.set(Relay.Value.kForward);
	}
	
	public void clawBeltPull() {
		clawBelt.set(Relay.Value.kReverse);
	}
	
	public void clawBeltStop() {
		clawBelt.set(Relay.Value.kOff);
	}
}
