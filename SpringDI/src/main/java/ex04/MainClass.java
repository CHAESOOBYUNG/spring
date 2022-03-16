package ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("autowired-context.xml");
		
		Printer pt = ctx.getBean(Printer.class);
		System.out.println(pt.getDoc().data);
		
		
		Printers pts = ctx.getBean(Printers.class);
		System.out.println(pts.getDoc().data);
		
	}
}
