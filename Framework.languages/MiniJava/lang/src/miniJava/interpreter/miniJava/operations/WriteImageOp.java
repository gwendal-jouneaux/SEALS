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
import miniJava.interpreter.miniJava.And;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import miniJava.interpreter.miniJava.WriteImage;
import minijava.ImageService;

@Operationalize(node = WriteImage.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class WriteImageOp extends Operation<WriteImage>{

	private void writeImage(String path, Object image) {
		ArrayInstance imgInstance = ((ArrayRefValue) image).getInstance();
		int h = imgInstance.getSize();
		int w = ((ArrayRefValue) imgInstance.getValue().get(0)).getInstance().getSize();
		
		BufferedImage jImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < h; y++) {
			ArrayInstance line = ((ArrayRefValue) imgInstance.getValue().get(y)).getInstance();
			for (int x = 0; x < w; x++) {
				IntegerValue idv = (IntegerValue) line.getValue().get(x);
				int grey = idv.getValue();
				jImage.setRGB(x, y, grey+grey*256+grey*256*256);
			}
		}
		File output = new File(path);
		try {
			ImageIO.write(jImage, path.substring(path.lastIndexOf(".")+1), output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object execute(SelfAdaptiveVisitor vis, WriteImage node, Object execCtx) {
		writeImage((String) (((Value) (((Expression) (node.getPath())).accept(vis,(State) (execCtx)))).customToString()), (Value) (((Expression) (node.getImage())).accept(vis,(State) (execCtx))));
		return null;
	}
}
