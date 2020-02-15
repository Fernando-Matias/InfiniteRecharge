/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class ControlPanelManipulator extends SubsystemBase {
  
  //call back to
  private static final ControlPanelManipulator instance = new ControlPanelManipulator();

  public static ControlPanelManipulator GetInstance() {
    return instance;
  }

  public Solenoid CPManipulatorExtend, CPManipulatorRetract;
  public TalonSRX CPManipulatorMotor;

  public ControlPanelManipulator() {
    CPManipulatorExtend = new Solenoid(RobotMap.PCM_B, RobotMap.pCPManipulatorExtend_ID);
    CPManipulatorRetract = new Solenoid(RobotMap.PCM_A, RobotMap.PCPManipulatorRetract_ID);
    
    CPManipulatorMotor = new TalonSRX(RobotMap.mCPManipulator_ID);

    CPManipulatorMotor.configFactoryDefault();
    CPManipulatorMotor.setNeutralMode(NeutrolMode.Brake);
    CPManipulatorMotor.configContinuousCurrentLimit(30);
    CPManipulatorMotor.configPeakCurrentLimit(0);
    CPManipulatorMotor.enableCurrentLimit(true);
    CPManipulatorMotor.setInverted(false);
  }

//Manipulator Control
  public void SpinControlPanel() {
    CPManipulatorMotor.set(ControlMode.PercentOutput, 1.0);
  }
  public void StopSpinControlPanel() {
    CPManipulatorMotor.set(ControlMode.PercentOutput, 0.0);
  }
//Pneumatics Control
  public void PushUpManipulator() {
    CPManipulatorRetract.set(Constants.On);
    CPManipulatorExtend.set(Constants.Off);
  }
  public void PushDownManipulator() {
    CPManipulatorRetract.set(Constants.Off);
    CPManipulatorExtend.set(Constants.On);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
