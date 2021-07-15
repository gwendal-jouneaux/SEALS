package miniJava.interpreter.miniJava.operations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.LoadImage;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;

@Operationalize(node = LoadImage.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class LoadImageOp extends Operation<LoadImage>{
	
	private Value loadImage(State state, String path) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("ERROR loading image");
			return null;
		}
		int h = img.getHeight();
		int w = img.getWidth();
		
		MiniJavaFactory factory = MiniJavaFactory.eINSTANCE;
		
		ArrayInstance res = factory.createArrayInstance();
		res.setSize(h);
		state.getArraysHeap().add((miniJava.interpreter.miniJava.ArrayInstance) res);
		
		for (int y = 0; y < h; y++) {
			ArrayInstance line = factory.createArrayInstance();
			line.setSize(w);
			for (int x = 0; x < w; x++) {
				IntegerValue idv = factory.createIntegerValue();
				int rgb = img.getRGB(x, y);
				int b = (rgb)&0xFF;
				int g = (rgb>>8)&0xFF;
				int r = (rgb>>16)&0xFF;
				idv.setValue((r+g+b)/3);
				line.getValue().add(idv);
			}
			ArrayRefValue lineRef = factory.createArrayRefValue();
			lineRef.setInstance(line);
			res.getValue().add(lineRef);
		}
		
		ArrayRefValue ret = factory.createArrayRefValue();
		ret.setInstance(res);
		return ret;
	}

	@Override
	public Object execute(SelfAdaptiveVisitor vis, LoadImage node, Object execCtx) {
		Value result;
		result = (Value) (loadImage((State) (execCtx), (String) (((Value) (((Expression) (node.getPath())).accept(vis,(State) (execCtx)))).customToString()))) ;
		return result;
	}
}
