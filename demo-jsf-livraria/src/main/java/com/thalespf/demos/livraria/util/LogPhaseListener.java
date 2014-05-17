/**
 * 
 */
package com.thalespf.demos.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@SuppressWarnings("serial")
public class LogPhaseListener implements PhaseListener {
	
	private static final Logger logger = Logger
			.getLogger(LogPhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		logger.info("Fase: " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
