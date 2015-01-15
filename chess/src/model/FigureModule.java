/**
 * 
 */
package model;

import com.google.inject.AbstractModule;

/**
 * @author Felix
 *
 */
public class FigureModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(Figure.class)
			.to(Pawn.class);
		
		bind(Figure.class)
		.to(Bishop.class);
		
		bind(Figure.class)
		.to(Knight.class);
		
		bind(Figure.class)
		.to(Queen.class);
		
		bind(Figure.class)
		.to(King.class);
		
		bind(Figure.class)
		.to(Rook.class);

	}

}
