#!/bin/python3
from string import Template

t = Template('''package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.$classname;

@Operationalize(node = $classname.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ${classname}Op extends Operation<$classname> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, $classname e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;

		return null;
	}

}''')


toGenerate = [
"And",
"AnnotatedStatement",
"ArrayAdd",
"ArrayGet",
"ArrayLength",
"ArrayNew",
"ArrayRemove",
"ArraySet",
"Assignment",
"Block",
"BoolConstant",
"Break",
"Condition",
"Divide",
"DoubleConstant",
"Equality",
"FunCall",
"FunParamCapture",
"FunParamExp",
"Greater",
"GreaterEq",
"Inequality",
"IntConstant",
"Less",
"LessEq",
"Loop",
"MathAbs",
"MathCos",
"MathModulo",
"MathPow",
"MathSin",
"MathSqrt",
"Minus",
"MoveBackward",
"MoveForward",
"Multiply",
"Not",
"Or",
"Plus",
"PrintExpression",
"Return",
"Robot",
"SenseBattery",
"SenseCompass",
"SenseDistance",
"SensePosition",
"SenseTime",
"SetNominalSpeed",
"StringConstant",
"SymbolRef",
"TurnLeft",
"TurnRight",
"Variable"
]

for classToGenerate in toGenerate:
    print(classToGenerate)
    file = open(classToGenerate+"Op.java","w") 
    file.write(t.substitute(classname=classToGenerate))
    file.close() 