package com.oracle.truffle.adaptable.language;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.EventContext;
import com.oracle.truffle.api.instrumentation.ExecutionEventListener;

public class FeedbackLoopExecutor implements ExecutionEventListener {
	
	private AdaptationContext adaptationContext;
	private FeedbackLoop loop;
	
	public FeedbackLoopExecutor(FeedbackLoop loop) {
		adaptationContext = loop.getAdaptationContext();
		this.loop = loop;
	}

	@Override
	public void onEnter(EventContext context, VirtualFrame frame) {
		if (!loop.additionalFilter(context.getInstrumentedNode())) {
			return;
		}
		TruffleAdaptableLanguage.monitor(adaptationContext);
		TruffleAdaptableLanguage.analyze(adaptationContext);
		TruffleAdaptableLanguage.plan   (adaptationContext);
		TruffleAdaptableLanguage.execute(adaptationContext);
	}

	@Override
	public void onReturnValue(EventContext context, VirtualFrame frame, Object result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReturnExceptional(EventContext context, VirtualFrame frame, Throwable exception) {
		// TODO Auto-generated method stub

	}

}
