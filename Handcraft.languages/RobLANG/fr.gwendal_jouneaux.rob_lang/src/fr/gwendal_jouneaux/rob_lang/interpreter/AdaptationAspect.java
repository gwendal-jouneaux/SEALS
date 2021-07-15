package fr.gwendal_jouneaux.rob_lang.interpreter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eclipse.emf.ecore.EObject;

import fr.gwendal_jouneaux.rob_lang.interpreter.AbstractAdaptationModule.Strategy;


/**
 * AdaptationAspect : Aspect that create the glue between the interpreter and the adaptation concerns
 * @author gjouneau
 *
 */
@Aspect
public class AdaptationAspect {

	/**
	 * aroundNode : add calls to adaptive modules before and after the semantics execution.
	 * Moreover, allow to shortcut semantics from modules using the AROUND {@link AbstractAdaptationModule.Strategy}
	 * and override the result of the execution
	 * @param pjp : The joinpoint giving access to the context of the code injection(i.e. AST node executed)
	 * @return The value resulting of the computation or an override of this value
	 * @throws Throwable
	 */
	@Around("execution(Object fr.gwendal_jouneaux.rob_lang.interpreter.InterpretRobLANG.interpretAdapt(..))")
    public Object aroundNode(ProceedingJoinPoint pjp) throws Throwable {
		Object interpreter = InterpretRobLANG.INSTANCE();
		EObject node = (EObject) pjp.getArgs()[0];
		
		Object out = FeedbackLoop.INSTANCE().interpret(interpreter, node, pjp.getArgs());

		if(! FeedbackLoop.INSTANCE().isOverridingSemantics()){
			out = pjp.proceed();
		}
		
		return out;
    }
}
