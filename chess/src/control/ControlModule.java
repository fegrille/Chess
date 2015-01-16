/**
 * 
 */
package control;

import com.google.inject.AbstractModule;

/**
 * @author Felix
 *
 */
public class ControlModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		
		bind(IControlColidateBishop.class)
		.to(ControlColidateBishop.class);
		
		bind(IControlColidateKnight.class)
		.to(ControlColidateKnight.class);
		
		bind(IControlColidateRook.class)
		.to(ControlColidateRook.class);
		
		bind(IControlColidateQueen.class)
		.to(ControlColidateQueen.class);
		
		bind(IControlColidateKing.class)
		.to(ControlColidateKing.class);
		
		bind(IControlColidatePawn.class)
		.to(ControlColidatePawn.class);
		
		bind(IControlPawn.class)
		.to(ControlPawn.class);

	}

}
