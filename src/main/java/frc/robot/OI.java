/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Input.*;

/**
 * @author Fernando Matias
 */
public class OI {
    private static final LogitechAttack3Joystick LeftStick = new LogitechAttack3Joystick(RobotMap.mLeftStickPort);
    private static final LogitechAttack3Joystick RightStick = new LogitechAttack3Joystick(RobotMap.mRightStickPort);
    private static final LogitechController Gamepad = new LogitechController(RobotMap.mGamepadPort);

    public void registerControls(){
      
        
    }

    public static double getLeftThrottleInput() {
      return LeftStick.getYAxis();
    }
    public static double getRightThrottleInput() {
      return RightStick.getYAxis(); 
    }
    public static double getLeftSteeringInput() {
      return LeftStick.getXAxis();
    }
    public static double getRightSteeringInput() {
      return RightStick.getXAxis();
    }
    public static double getLeftThrottleInputInverted() {
      return LeftStick.getYAxisInverted();
    }
    public static double getRightThrottleInputInverted() {
      return RightStick.getYAxisInverted();
    }
    public static double getLeftSteeringInputInverted() {
      return LeftStick.getXAxisInverted();
    }
    public static double getRightSteeringInputInverted() {
      return RightStick.getXAxisInverted();
    }

}
 
    
