package fr.gjouneau.self.adaptation.framework.HTML;

public class PrettyPrinter implements fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor {
	public Object visitHTMLNodeAttribute(fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute node, Object execCtx, fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.AttributeInterface config){ return (new fr.gjouneau.self.adaptation.framework.HTML.nodes.operations.HTMLOperationAttribute()).execute(this,node,execCtx,config);}
	public Object visitHTMLNodeRoot(fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot node, Object execCtx){ return (new fr.gjouneau.self.adaptation.framework.HTML.nodes.operations.HTMLOperationRoot()).execute(this,node,execCtx);}
	public Object visitHTMLNodePlainText(fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodePlainText node, Object execCtx){ return (new fr.gjouneau.self.adaptation.framework.HTML.nodes.operations.HTMLOperationPlainText()).execute(this,node,execCtx);}
	public Object visitHTMLNodeBlockTag(fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBlockTag node, Object execCtx, fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.BlockTagInterface config){ return (new fr.gjouneau.self.adaptation.framework.HTML.nodes.operations.HTMLOperationBlockTag()).execute(this,node,execCtx,config);}
	public Object visitHTMLNodeEmptyTag(fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeEmptyTag node, Object execCtx, fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.TagInterface config){ return (new fr.gjouneau.self.adaptation.framework.HTML.nodes.operations.HTMLOperationEmptyTag()).execute(this,node,execCtx,config);}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.Node node, Object executionCtx){
		if(node instanceof fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot){
			return visitHTMLNodeRoot((fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot) node, executionCtx);
		}
		if(node instanceof fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodePlainText){
			return visitHTMLNodePlainText((fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodePlainText) node, executionCtx);
		}
		return null;
	}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.AdaptableNode node, Object executionCtx, fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface config){
		if(node instanceof fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute){
			return visitHTMLNodeAttribute((fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute) node, executionCtx,(fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.AttributeInterface) config);
		}
		if(node instanceof fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBlockTag){
			return visitHTMLNodeBlockTag((fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBlockTag) node, executionCtx,(fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.BlockTagInterface) config);
		}
		if(node instanceof fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeEmptyTag){
			return visitHTMLNodeEmptyTag((fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeEmptyTag) node, executionCtx,(fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.TagInterface) config);
		}
		return null;
	}
}