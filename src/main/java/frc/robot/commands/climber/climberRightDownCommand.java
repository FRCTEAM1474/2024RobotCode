package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.climber.climberSubsystem;

public class climberRightDownCommand extends Command {

    private final climberSubsystem m_ClimberSubsystem;
    public climberRightDownCommand(climberSubsystem subsystem) {
        m_ClimberSubsystem = subsystem;
        addRequirements(m_ClimberSubsystem);
    }

    @Override
    public void initialize() {
    
    }

    @Override
    public void execute() {
            m_ClimberSubsystem.setRightClimberDown();
    }

    @Override
    public void end (boolean interrupted) {
        m_ClimberSubsystem.setRightClimberNeutral();
    }

    @Override
    public boolean isFinished(){
    return m_ClimberSubsystem.getRightDown();
}
}