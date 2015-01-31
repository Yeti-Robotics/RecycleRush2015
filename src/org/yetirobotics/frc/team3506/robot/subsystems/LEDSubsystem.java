package org.yetirobotics.frc.team3506.robot.subsystems;

import org.yetirobotics.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDSubsystem extends Subsystem {
    DigitalOutput colorController;
    boolean toggledLightsOn = false;
    Relay ledPower;
    Value areLightsOn;
	
	
    public void initDefaultCommand() {
    	colorController = new DigitalOutput(RobotMap.COLOR_CONTROLLER_PORT);
    	ledPower = new Relay(RobotMap.LED_POWER_PORT);
    	areLightsOn = Value.kOff;
    }
    
    public void changeLightSpeed() {
    	toggledLightsOn = !toggledLightsOn;
    	colorController.set(toggledLightsOn);
    }
    
    public void toggleLeds() {
    	if (areLightsOn == Value.kOff) {
        	ledPower.set(Value.kForward);
        	areLightsOn = Value.kForward;
    	}
    	else if (areLightsOn == Value.kForward) {
        	ledPower.set(Value.kOff);
        	areLightsOn = Value.kOff;
    	}
    }
}

